package com.feiying.erp.service.orgaUserRel;

import com.feiying.erp.service.ICommonQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;


@Service(value = "orgaUserRel_component")
@OrgaUserRelResource
public class OrgaUserRelComponent implements ICommonQuery {
    @Resource
    private OrgaUserRelService orgaUserRelService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return orgaUserRelService.getOrgaUserRel(id);
    }

    @Override
    public List<?> select(Map<String, String> parameterMap)throws Exception {
        return getOrgaUserRelList(parameterMap);
    }
    private List<?> getOrgaUserRelList(Map<String, String> map)throws Exception {
        return null;
    }
    @Override
    public Long counts(Map<String, String> parameterMap)throws Exception {
        return null;
    }

    @Override
    public int insert(String beanJson, HttpServletRequest request)throws Exception {
        return orgaUserRelService.insertOrgaUserRel(beanJson,request);
    }

    @Override
    public int update(String beanJson, Long id)throws Exception {
        return orgaUserRelService.updateOrgaUserRel(beanJson,id);
    }

    @Override
    public int delete(Long id)throws Exception {
        return orgaUserRelService.deleteOrgaUserRel(id);
    }

    @Override
    public int batchDelete(String ids)throws Exception {
        return orgaUserRelService.batchDeleteOrgaUserRel(ids);
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        return 0;
    }
}
