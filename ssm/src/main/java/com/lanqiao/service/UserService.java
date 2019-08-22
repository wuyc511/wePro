package com.lanqiao.service;

import com.github.pagehelper.PageInfo;
import com.lanqiao.model.User;

public interface UserService {
	PageInfo<User> getPage(int pageno,int pagesize,User user);
	User login(String username,String password);
	int insert(User user) ;
	User get(int userid);
	int update(User user);
	int delete(int id);
}
