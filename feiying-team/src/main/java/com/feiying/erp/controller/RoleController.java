package com.feiying.erp.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.feiying.erp.constants.ExceptionConstants;
import com.feiying.erp.datasource.entities.Role;
import com.feiying.erp.exception.BusinessRunTimeException;
import com.feiying.erp.service.role.RoleService;
import com.feiying.erp.service.userBusiness.UserBusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 */
@RestController
@RequestMapping(value = "/role")
public class RoleController {
    private Logger logger = LoggerFactory.getLogger(RoleController.class);

    @Resource
    private RoleService roleService;

    @Resource
    private UserBusinessService userBusinessService;

    /**
     * 角色对应应用显示
     * @param request
     * @return
     */
    @PostMapping(value = "/findUserRole")
    public JSONArray findUserRole(@RequestParam("UBType") String type, @RequestParam("UBKeyId") String keyId,
                                  HttpServletRequest request)throws Exception {
        JSONArray arr = new JSONArray();
        try {
            List<Role> dataList = roleService.findUserRole();
            //开始拼接json数据
            JSONObject outer = new JSONObject();
            outer.put("id", 1);
            outer.put("text", "角色列表");
            outer.put("state", "open");
            //存放数据json数组
            JSONArray dataArray = new JSONArray();
            if (null != dataList) {
                for (Role role : dataList) {
                    JSONObject item = new JSONObject();
                    item.put("id", role.getId());
                    item.put("text", role.getName());
                    //勾选判断1
                    Boolean flag = false;
                    try {
                        flag = userBusinessService.checkIsUserBusinessExist(type, keyId, "[" + role.getId().toString() + "]");
                    } catch (Exception e) {
                        logger.error(">>>>>>>>>>>>>>>>>设置用户对应的角色：类型" + type + " KeyId为： " + keyId + " 存在异常！");
                    }
                    if (flag == true) {
                        item.put("checked", true);
                    }
                    //结束
                    dataArray.add(item);
                }
            }
            outer.put("children", dataArray);
            arr.add(outer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arr;
    }

    @PostMapping(value = "/list")
    public List<Role> list(HttpServletRequest request)throws Exception {
        return roleService.getRole();
    }

    /**
     * description:
     *  逻辑删除角色信息
     */
    @RequestMapping(value = "/batchDeleteRoleByIds")
    public Object batchDeleteRoleByIds(@RequestParam("ids") String ids) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        int i= roleService.batchDeleteRoleByIds(ids);
        if(i<1){
            logger.error("异常码[{}],异常提示[{}],参数,ids[{}]",
                    ExceptionConstants.ROLE_DELETE_FAILED_CODE,ExceptionConstants.ROLE_DELETE_FAILED_MSG,ids);
            throw new BusinessRunTimeException(ExceptionConstants.ROLE_DELETE_FAILED_CODE,
                    ExceptionConstants.ROLE_DELETE_FAILED_MSG);
        }
        return result;
    }

}
