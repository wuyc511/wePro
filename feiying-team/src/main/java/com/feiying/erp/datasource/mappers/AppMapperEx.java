package com.feiying.erp.datasource.mappers;

import com.feiying.erp.datasource.entities.App;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AppMapperEx {

    List<App> selectByConditionApp(
            @Param("name") String name,
            @Param("type") String type,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByApp(
            @Param("name") String name,
            @Param("type") String type);

    int batchDeleteAppByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String ids[]);
}