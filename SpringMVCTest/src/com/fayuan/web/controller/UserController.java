package com.fayuan.web.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fayuan.web.model.User;
import com.fayuan.web.service.impl.UserService;

@RestController
@Scope("prototype") //每次都创建一个UserController对象
@RequestMapping("/user")
public class UserController {

	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping("/save")
	public User view() {
		User user = new User();
		user.setId(1L);
		user.setName("fayuan");
		
		userService.saveUser(user);
		return user;
	}
}
