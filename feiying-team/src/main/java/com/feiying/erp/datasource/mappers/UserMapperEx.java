package com.feiying.erp.datasource.mappers;

import com.feiying.erp.datasource.entities.User;
import com.feiying.erp.datasource.entities.UserEx;
import com.feiying.erp.datasource.vo.TreeNodeEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapperEx {

    List<User> selectByConditionUser(
            @Param("userName") String userName,
            @Param("loginName") String loginName,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByUser(
            @Param("userName") String userName,
            @Param("loginName") String loginName);

    List<UserEx> getUserList(Map<String, Object> parameterMap);

    int addUser(UserEx ue);

    int updateUser(UserEx ue);

    List<User> getUserListByUserNameOrLoginName(@Param("userName") String userName,
                                                @Param("loginame") String loginame);

    int batDeleteOrUpdateUser(@Param("ids") String ids[], @Param("status") byte status);

    List<TreeNodeEx> getNodeTree();
    List<TreeNodeEx> getNextNodeTree(Map<String, Object> parameterMap);
}