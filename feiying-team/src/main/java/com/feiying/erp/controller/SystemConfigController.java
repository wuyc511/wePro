package com.feiying.erp.controller;

import com.alibaba.fastjson.JSONObject;
import com.feiying.erp.constants.ExceptionConstants;
import com.feiying.erp.exception.BusinessRunTimeException;
import com.feiying.erp.service.systemConfig.SystemConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/systemConfig")
public class SystemConfigController {
    private Logger logger = LoggerFactory.getLogger(SystemConfigController.class);
    @Resource
    private SystemConfigService systemConfigService;
    /**
     * description:
     *  批量删除系统配置信息
     * create time: 2019/3/29 11:15
     */
    @RequestMapping(value = "/batchDeleteSystemConfigByIds")
    public Object batchDeleteSystemConfigByIds(@RequestParam("ids") String ids) throws Exception {
        JSONObject result = ExceptionConstants.standardSuccess();
        int i= systemConfigService.batchDeleteSystemConfigByIds(ids);
        if(i<1){
            logger.error("异常码[{}],异常提示[{}],参数,ids[{}]",
                    ExceptionConstants.SYSTEM_CONFIG_DELETE_FAILED_CODE,ExceptionConstants.SYSTEM_CONFIG_DELETE_FAILED_MSG,ids);
            throw new BusinessRunTimeException(ExceptionConstants.SYSTEM_CONFIG_DELETE_FAILED_CODE,
                    ExceptionConstants.SYSTEM_CONFIG_DELETE_FAILED_MSG);
        }
        return result;
    }

}
