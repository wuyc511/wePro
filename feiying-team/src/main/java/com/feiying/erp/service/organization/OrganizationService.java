package com.feiying.erp.service.organization;

import com.alibaba.fastjson.JSONObject;
import com.feiying.erp.constants.BusinessConstants;
import com.feiying.erp.constants.ExceptionConstants;
import com.feiying.erp.datasource.entities.Organization;
import com.feiying.erp.datasource.entities.OrganizationExample;
import com.feiying.erp.datasource.entities.User;
import com.feiying.erp.datasource.mappers.OrganizationMapper;
import com.feiying.erp.datasource.mappers.OrganizationMapperEx;
import com.feiying.erp.datasource.vo.TreeNode;
import com.feiying.erp.exception.BusinessRunTimeException;
import com.feiying.erp.service.log.LogService;
import com.feiying.erp.service.user.UserService;
import com.feiying.erp.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Description
 */
@Service
public class OrganizationService {
    private Logger logger = LoggerFactory.getLogger(OrganizationService.class);

    @Resource
    private OrganizationMapper organizationMapper;
    @Resource
    private OrganizationMapperEx organizationMapperEx;
    @Resource
    private UserService userService;
    @Resource
    private LogService logService;

    public Organization getOrganization(long id) throws Exception {
        return organizationMapper.selectByPrimaryKey(id);
    }

    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int insertOrganization(String beanJson, HttpServletRequest request)throws Exception {
        Organization organization = JSONObject.parseObject(beanJson, Organization.class);
        int result=0;
        try{
            result=organizationMapper.insertSelective(organization);
        }catch(Exception e){
            logger.error("异常码[{}],异常提示[{}],异常[{}]",
                    ExceptionConstants.DATA_WRITE_FAIL_CODE,ExceptionConstants.DATA_WRITE_FAIL_MSG,e);
            throw new BusinessRunTimeException(ExceptionConstants.DATA_WRITE_FAIL_CODE,
                    ExceptionConstants.DATA_WRITE_FAIL_MSG);
        }
        return result;
    }
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int updateOrganization(String beanJson, Long id)throws Exception {
        Organization organization = JSONObject.parseObject(beanJson, Organization.class);
        organization.setId(id);
        int result=0;
        try{
            result=organizationMapper.updateByPrimaryKeySelective(organization);
        }catch(Exception e){
            logger.error("异常码[{}],异常提示[{}],异常[{}]",
                    ExceptionConstants.DATA_WRITE_FAIL_CODE,ExceptionConstants.DATA_WRITE_FAIL_MSG,e);
            throw new BusinessRunTimeException(ExceptionConstants.DATA_WRITE_FAIL_CODE,
                    ExceptionConstants.DATA_WRITE_FAIL_MSG);
        }
        return result;
    }
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int deleteOrganization(Long id)throws Exception {
        int result=0;
        try{
            result=organizationMapper.deleteByPrimaryKey(id);
        }catch(Exception e){
            logger.error("异常码[{}],异常提示[{}],异常[{}]",
                    ExceptionConstants.DATA_WRITE_FAIL_CODE,ExceptionConstants.DATA_WRITE_FAIL_MSG,e);
            throw new BusinessRunTimeException(ExceptionConstants.DATA_WRITE_FAIL_CODE,
                    ExceptionConstants.DATA_WRITE_FAIL_MSG);
        }
        return result;
    }
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteOrganization(String ids)throws Exception {
        List<Long> idList = StringUtil.strToLongList(ids);
        OrganizationExample example = new OrganizationExample();
        example.createCriteria().andIdIn(idList);
        int result=0;
        try{
            result=organizationMapper.deleteByExample(example);
        }catch(Exception e){
            logger.error("异常码[{}],异常提示[{}],异常[{}]",
                    ExceptionConstants.DATA_WRITE_FAIL_CODE,ExceptionConstants.DATA_WRITE_FAIL_MSG,e);
            throw new BusinessRunTimeException(ExceptionConstants.DATA_WRITE_FAIL_CODE,
                    ExceptionConstants.DATA_WRITE_FAIL_MSG);
        }
        return result;
    }
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int addOrganization(Organization org) throws Exception{
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_ORGANIZATION,
                BusinessConstants.LOG_OPERATION_TYPE_ADD,
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        //新增时间
        Date date=new Date();
        User userInfo=userService.getCurrentUser();
        org.setCreateTime(date);
        //新增人
        org.setCreator(userInfo==null?null:userInfo.getId());
        //修改时间
        org.setUpdateTime(date);
        //修改人
        org.setUpdater(userInfo==null?null:userInfo.getId());
        /**
         *添加的时候检测机构编号是否已存在
         * */
        if(StringUtil.isNotEmpty(org.getOrgNo())){
            checkOrgNoIsExists(org.getOrgNo(),null);
        }
        /**
         * 未指定父级机构的时候默认为根机构
         * */
        if(StringUtil.isEmpty(org.getOrgParentNo())){
            org.setOrgParentNo(BusinessConstants.ORGANIZATION_ROOT_PARENT_NO);
        }
        int result=0;
        try{
            result=organizationMapperEx.addOrganization(org);
        }catch(Exception e){
            logger.error("异常码[{}],异常提示[{}],异常[{}]",
                    ExceptionConstants.DATA_WRITE_FAIL_CODE,ExceptionConstants.DATA_WRITE_FAIL_MSG,e);
            throw new BusinessRunTimeException(ExceptionConstants.DATA_WRITE_FAIL_CODE,
                    ExceptionConstants.DATA_WRITE_FAIL_MSG);
        }
        return result;
    }
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int editOrganization(Organization org)throws Exception {
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_ORGANIZATION,
               new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_EDIT).append(org.getId()).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        //修改时间
        org.setUpdateTime(new Date());
        User userInfo=userService.getCurrentUser();
        //修改人
        org.setUpdater(userInfo==null?null:userInfo.getId());
        /**
         * 修改的时候检测机构编号是否已存在
         * */
        if(StringUtil.isNotEmpty(org.getOrgNo())){
            checkOrgNoIsExists(org.getOrgNo(),org.getId());
        }
        /**
         * 未指定父级机构的时候默认为根机构
         * */
        if(StringUtil.isEmpty(org.getOrgParentNo())){
            org.setOrgParentNo(BusinessConstants.ORGANIZATION_ROOT_PARENT_NO);
        }
        int result=0;
        try{
            result=organizationMapperEx.editOrganization(org);
        }catch(Exception e){
            logger.error("异常码[{}],异常提示[{}],异常[{}]",
                    ExceptionConstants.DATA_WRITE_FAIL_CODE,ExceptionConstants.DATA_WRITE_FAIL_MSG,e);
            throw new BusinessRunTimeException(ExceptionConstants.DATA_WRITE_FAIL_CODE,
                    ExceptionConstants.DATA_WRITE_FAIL_MSG);
        }
        return result;
    }

    public List<TreeNode> getOrganizationTree(Long id)throws Exception {
        List<TreeNode> list=null;
        try{
            list=organizationMapperEx.getNodeTree(id);
        }catch(Exception e){
            logger.error("异常码[{}],异常提示[{}],异常[{}]",
                    ExceptionConstants.DATA_READ_FAIL_CODE,ExceptionConstants.DATA_READ_FAIL_MSG,e);
            throw new BusinessRunTimeException(ExceptionConstants.DATA_READ_FAIL_CODE,
                    ExceptionConstants.DATA_READ_FAIL_MSG);
        }
        return list;
    }

    public List<Organization> findById(Long id) throws Exception{
        OrganizationExample example = new OrganizationExample();
        example.createCriteria().andIdEqualTo(id);
        List<Organization> list=null;
        try{
            list=organizationMapper.selectByExample(example);
        }catch(Exception e){
            logger.error("异常码[{}],异常提示[{}],异常[{}]",
                    ExceptionConstants.DATA_READ_FAIL_CODE,ExceptionConstants.DATA_READ_FAIL_MSG,e);
            throw new BusinessRunTimeException(ExceptionConstants.DATA_READ_FAIL_CODE,
                    ExceptionConstants.DATA_READ_FAIL_MSG);
        }
        return list;
    }

    public List<Organization> findByOrgNo(String orgNo)throws Exception {
        OrganizationExample example = new OrganizationExample();
        example.createCriteria().andOrgNoEqualTo(orgNo).andOrgStcdNotEqualTo(BusinessConstants.ORGANIZATION_STCD_REMOVED);
        List<Organization> list=null;
        try{
            list=organizationMapper.selectByExample(example);
        }catch(Exception e){
            logger.error("异常码[{}],异常提示[{}],异常[{}]",
                    ExceptionConstants.DATA_READ_FAIL_CODE,ExceptionConstants.DATA_READ_FAIL_MSG,e);
            throw new BusinessRunTimeException(ExceptionConstants.DATA_READ_FAIL_CODE,
                    ExceptionConstants.DATA_READ_FAIL_MSG);
        }
        return list;
    }
    /**
     * create by: cjl
     * description:
     *  检查机构编号是否已经存在
     * create time: 2019/3/7 10:01
     * @Param: orgNo
     * @return void
     */
    public void checkOrgNoIsExists(String orgNo,Long id)throws Exception {
        List<Organization> orgList=findByOrgNo(orgNo);
        if(orgList!=null&&orgList.size()>0){
            if(orgList.size()>1){
                logger.error("异常码[{}],异常提示[{}],参数,orgNo[{}]",
                        ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_CODE,ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_MSG,orgNo);
                //获取的数据条数大于1，机构编号已存在
                throw new BusinessRunTimeException(ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_CODE,
                        ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_MSG);
            }
            if(id!=null){
                if(!orgList.get(0).getId().equals(id)){
                    //数据条数等于1，但是和编辑的数据的id不相同
                    logger.error("异常码[{}],异常提示[{}],参数,orgNo[{}],id[{}]",
                            ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_CODE,ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_MSG,orgNo,id);
                    throw new BusinessRunTimeException(ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_CODE,
                            ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_MSG);
                }
            }else{
                logger.error("异常码[{}],异常提示[{}],参数,orgNo[{}]",
                        ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_CODE,ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_MSG,orgNo);
                //数据条数等于1，但此时是新增
                throw new BusinessRunTimeException(ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_CODE,
                        ExceptionConstants.ORGANIZATION_NO_ALREADY_EXISTS_MSG);
            }
        }

    }
    @Transactional(value = "transactionManager", rollbackFor = Exception.class)
    public int batchDeleteOrganizationByIds(String ids) throws Exception{
        logService.insertLog(BusinessConstants.LOG_INTERFACE_NAME_ORGANIZATION,
                new StringBuffer(BusinessConstants.LOG_OPERATION_TYPE_DELETE).append(ids).toString(),
                ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest());
        User userInfo=userService.getCurrentUser();
        String [] idArray=ids.split(",");
        int result=0;
        try{
            result=organizationMapperEx.batchDeleteOrganizationByIds(
                    new Date(),userInfo==null?null:userInfo.getId(),idArray);
        }catch(Exception e){
            logger.error("异常码[{}],异常提示[{}],异常[{}]",
                    ExceptionConstants.DATA_WRITE_FAIL_CODE,ExceptionConstants.DATA_WRITE_FAIL_MSG,e);
            throw new BusinessRunTimeException(ExceptionConstants.DATA_WRITE_FAIL_CODE,
                    ExceptionConstants.DATA_WRITE_FAIL_MSG);
        }
        return result;
    }
}
