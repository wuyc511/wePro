package com.lanqiao.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lanqiao.dao.UserDao;
import com.lanqiao.model.User;
import com.lanqiao.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao ;
	
	

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return userDao.login(username, password);
	}

	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return userDao.insert(user);
	}

	@Override
	public User get(int userid) {
		// TODO Auto-generated method stub
		return userDao.get(userid);
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return userDao.update(user);
	}

	@Override
	public PageInfo<User> getPage(int pageno, int pagesize,User user) {
		 PageHelper.startPage(pageno, pagesize);
		 List<User> list = userDao.getAll(user);
		 PageInfo<User> page = new PageInfo<User>(list);
		 return page;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return userDao.delete(id);
	}

	

}
