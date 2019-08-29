package com.feiying.erp.datasource.mappers;

import com.feiying.erp.datasource.entities.Organization;
import com.feiying.erp.datasource.vo.TreeNode;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Description
 *
 * @Author: cjl
 * @Date: 2019/3/6 15:51
 */
public interface OrganizationMapperEx {


    List<TreeNode> getNodeTree(@Param("currentId")Long currentId);
    List<TreeNode> getNextNodeTree(Map<String, Object> parameterMap);

    int addOrganization(Organization org);

    int batchDeleteOrganizationByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String ids[]);

    int editOrganization(Organization org);
    List <Organization> getOrganizationRootByIds(@Param("ids") String ids[]);
}
