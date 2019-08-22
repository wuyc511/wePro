package com.lanqiao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lanqiao.model.User;
import com.lanqiao.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("")
@Api(tags="用户管理模块")
public class UserRestController {

	@Autowired
	private UserService userService  ;
	
	@GetMapping("user/{id}")
	@ApiOperation(value="根据ID获得用户")
	@ApiParam(value="用户ID")
	public User get(@PathVariable("id")int userid) {
		User u = userService.get(userid);
		return u ;
	}
	@ApiOperation(value="根据ID删除用户")
	@DeleteMapping("user/{id}")
	public String delete(@PathVariable("id") int id) {
		int result = userService.delete(id) ;
		if(result > 0) {
			return "success" ;
		}else {
			return "error" ;
		}
	}
	
	@PostMapping("user")
	public String update(User user) {
		int result = userService.update(user);
		if(result > 0) {
			return "success" ;
		}else {
			return "error" ;
		}
	}
	
	@PutMapping("user")
	public String add(User user) {
		int result = userService.insert(user);
		if(result > 0) {
			return "success" ;
		}else {
			return "error" ;
		}
	}
	
	
	
}
