package com.feiying.erp.service.functions;

import com.feiying.erp.service.ICommonQuery;
import com.feiying.erp.utils.Constants;
import com.feiying.erp.utils.QueryUtils;
import com.feiying.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "functions_component")
@FunctionsResource
public class FunctionsComponent implements ICommonQuery {

    @Resource
    private FunctionsService functionsService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return functionsService.getFunctions(id);
    }

    @Override
    public List<?> select(Map<String, String> map)throws Exception {
        return getFunctionsList(map);
    }

    private List<?> getFunctionsList(Map<String, String> map) throws Exception{
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        String type = StringUtil.getInfo(search, "type");
        String order = QueryUtils.order(map);
        return functionsService.select(name, type, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map) throws Exception{
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        String type = StringUtil.getInfo(search, "type");
        return functionsService.countFunctions(name, type);
    }

    @Override
    public int insert(String beanJson, HttpServletRequest request)throws Exception {
        return functionsService.insertFunctions(beanJson, request);
    }

    @Override
    public int update(String beanJson, Long id)throws Exception {
        return functionsService.updateFunctions(beanJson, id);
    }

    @Override
    public int delete(Long id)throws Exception {
        return functionsService.deleteFunctions(id);
    }

    @Override
    public int batchDelete(String ids)throws Exception {
        return functionsService.batchDeleteFunctions(ids);
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        return functionsService.checkIsNameExist(id, name);
    }

}
