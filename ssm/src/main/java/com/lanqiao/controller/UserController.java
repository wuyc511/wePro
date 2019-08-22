package com.lanqiao.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.lanqiao.model.User;
import com.lanqiao.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService  ;
	
	
	@RequestMapping("search.action")
	public ModelAndView getpage(@RequestParam(required=false,defaultValue="1")int pageno,
								@RequestParam(required=false,defaultValue="3")int pagesize,
								@RequestParam(required=false)String val,@RequestParam(required=false)String type) {
		ModelAndView mv = new ModelAndView();
		User u = new User();
		if("username".equals(type)) {
			u.setUsername(val);
		}
		if("id".equals(type)) {
			u.setIdentityCode(val);
		}
		PageInfo<User> page = userService.getPage(pageno, pagesize,u);
		
		mv.addObject("page",page) ;
		mv.setViewName("userlist");
		return mv ;
	}
	
	@GetMapping("login.action")
	public String login() {
		return "login" ;
	}
	
	@GetMapping("register.action")
	public String register() {
		return "register" ;
	}
	
	@PostMapping("doLogin.action")
	public String doLogin(String username,String password) {
		
		User u = userService.login(username,password) ;
		if(u == null) {
			return "error" ;
		}else {
			return "redirect:search.action" ;
		}
	}
	
	@PostMapping("doRegister.action")
	public String doRegister(User user,MultipartFile pictureFile,HttpServletRequest req) {
		
		String name  = pictureFile.getOriginalFilename() ;  // 1.jpg  abc.y.jpg
		String fix = name.substring(name.lastIndexOf(".")) ;
		String newFilename = UUID.randomUUID() + fix ; 
		File file = new File("D://images" + "/" + newFilename);
		
		try {
			pictureFile.transferTo(file);
			user.setImage(newFilename);
			int re = userService.insert(user) ;
			if(re > 0) {
				return "login" ;
			}else {
				return "error" ;
			}
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		
//		
		return null;
	}
	
	@RequestMapping("edit.action")
	public String edit(@RequestParam("userid")Integer uid,Model model) {
		User user = userService.get(uid) ;
		if(user != null) {
			model.addAttribute("user", user);
			return "edit" ;
		}else {
			return "error"  ;
		}
	}
	
	@PostMapping("confirmEdit.action")
	public String confirmEdit(User user,Integer[] item_id) {
		
		int re = userService.update(user) ;
		if(re > 0) {
			return "redirect:search.action" ;
		}else {
			return "error" ;
		}
	}
	
	
	
	
}
