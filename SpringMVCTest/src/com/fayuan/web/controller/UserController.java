package com.fayuan.web.controller;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fayuan.web.model.User;
import com.fayuan.web.service.UserService;

@RestController
@Scope("prototype") //每次都创建一个UserController对象
@RequestMapping("/user")
public class UserController {

	//@Resource 的作用相当于 @Autowired，只不过 @Autowired 按 byType 自动注入，面@Resource 默认按 byName 自动注入罢了。
	//@Resource 有两个属性是比较重要的，分别是 name 和 type，Spring 将@Resource 注释的 name 属性解析为 Bean 的名字，
	//而 type 属性则解析为 Bean 的类型。所以如果使用 name 属性，则使用 byName 的自动注入策略，而使用 type 属性时则使用 byType 自动注入策略。
	//如果既不指定 name 也不指定 type 属性，这时将通过反射机制使用 byName 自动注入策略。
	//一般情况下，我们无需使用类似于 @Resource(type=Car.class) 的注释方式，因为 Bean 的类型信息可以通过 Java 反射从代码中获取。
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
