package com.feiying.erp.service.tenant;

import com.feiying.erp.service.ICommonQuery;
import com.feiying.erp.utils.Constants;
import com.feiying.erp.utils.QueryUtils;
import com.feiying.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "tenant_component")
@TenantResource
public class TenantComponent implements ICommonQuery {

    @Resource
    private TenantService tenantService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return tenantService.getTenant(id);
    }

    @Override
    public List<?> select(Map<String, String> map)throws Exception {
        return getTenantList(map);
    }

    private List<?> getTenantList(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String loginName = StringUtil.getInfo(search, "loginName");
        return tenantService.select(loginName, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String loginName = StringUtil.getInfo(search, "loginName");
        return tenantService.countTenant(loginName);
    }

    @Override
    public int insert(String beanJson, HttpServletRequest request)throws Exception {
        return tenantService.insertTenant(beanJson, request);
    }

    @Override
    public int update(String beanJson, Long id)throws Exception {
        return tenantService.updateTenant(beanJson, id);
    }

    @Override
    public int delete(Long id)throws Exception {
        return tenantService.deleteTenant(id);
    }

    @Override
    public int batchDelete(String ids)throws Exception {
        return tenantService.batchDeleteTenant(ids);
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        return tenantService.checkIsNameExist(id, name);
    }

}
