package com.lanqiao.dao;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;

import com.lanqiao.model.User;

public interface UserDao {
	
	
	List<User> getAll(User user) ;
	
	User login(String username,String password);
	
	int insert(User user) ;
	
	User get(int userid);
	
	int update(User user);
	
	int delete(int id);

}
