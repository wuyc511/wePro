package com.feiying.erp.service.depot;

import com.feiying.erp.service.ICommonQuery;
import com.feiying.erp.utils.Constants;
import com.feiying.erp.utils.QueryUtils;
import com.feiying.erp.utils.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service(value = "depot_component")
@DepotResource
public class DepotComponent implements ICommonQuery {

    @Resource
    private DepotService depotService;

    @Override
    public Object selectOne(Long id) throws Exception {
        return depotService.getDepot(id);
    }

    @Override
    public List<?> select(Map<String, String> map)throws Exception {
        return getDepotList(map);
    }

    private List<?> getDepotList(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        Integer type = StringUtil.parseInteger(StringUtil.getInfo(search, "type"));
        String remark = StringUtil.getInfo(search, "remark");
        String order = QueryUtils.order(map);
        return depotService.select(name, type, remark, QueryUtils.offset(map), QueryUtils.rows(map));
    }

    @Override
    public Long counts(Map<String, String> map)throws Exception {
        String search = map.get(Constants.SEARCH);
        String name = StringUtil.getInfo(search, "name");
        Integer type = StringUtil.parseInteger(StringUtil.getInfo(search, "type"));
        String remark = StringUtil.getInfo(search, "remark");
        return depotService.countDepot(name, type, remark);
    }

    @Override
    public int insert(String beanJson, HttpServletRequest request) throws Exception{
        return depotService.insertDepot(beanJson, request);
    }

    @Override
    public int update(String beanJson, Long id)throws Exception {
        return depotService.updateDepot(beanJson, id);
    }

    @Override
    public int delete(Long id)throws Exception {
        return depotService.deleteDepot(id);
    }

    @Override
    public int batchDelete(String ids)throws Exception {
        return depotService.batchDeleteDepot(ids);
    }

    @Override
    public int checkIsNameExist(Long id, String name)throws Exception {
        return depotService.checkIsNameExist(id, name);
    }

}
