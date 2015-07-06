package com.fayuan.web.service.impl;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.fayuan.web.dao.BaseDao;
import com.fayuan.web.model.User;
import com.fayuan.web.service.UserService;


@Service(value = "userService")
public class UserServiceImpl implements UserService {
	
	//@Autowired可以用在属性1、构造方法2、set方法3上，用于注入依赖对象
	//required = false 这等于告诉 Spring：在找不到匹配 Bean 时也不报错。
	//@Qualifier 注释指定注入 Bean 的名称(当存在多个相同的userDaoImpl的时候，才需要用)
	@Autowired(required = false)
	@Qualifier("userDaoImpl")
	BaseDao<User> userDaoImpl;	//1
	
	/*@Autowired
	public UserServiceImpl(@Qualifier("userDaoImpl") BaseDao<User> userDaoImpl) { //2	
		this.userDaoImpl = userDaoImpl;
	}*/
		
	/*@Autowired
	public void setUserDaoImpl(@Qualifier("userDaoImpl") BaseDao<User> userDaoImpl) { //3
		this.userDaoImpl = userDaoImpl;
	}*/
	
	@Override
	public boolean saveUser(User user) { 
		return userDaoImpl.save(user);
	}	
	
	/**
	 * JSR-250 规范定义的注释，它们分别是 @Resource、@PostConstruct 以及 @PreDestroy。
	 * 
	 * Spring 容器中的 Bean 是有生命周期的，Spring 允许在 Bean 在初始化完成后以及 Bean 销毁前执行特定的操作，
	 * 您既可以通过实现 InitializingBean/DisposableBean 接口来定制初始化之后 / 销毁之前的操作方法，
	 * 也可以通过 <bean> 元素的 init-method/destroy-method 属性指定初始化之后 / 销毁之前调用的操作方法。
	 * 
	 * 不管是通过实现 InitializingBean/DisposableBean 接口，还是通过 <bean> 元素的init-method/destroy-method 属性进行配置，
	 * 都只能为 Bean 指定一个初始化 / 销毁的方法。
	 * 但是使用@PostConstruct 和 @PreDestroy 注释却可以指定多个初始化 / 销毁方法，
	 * 那些被标注 @PostConstruct 或 @PreDestroy 注释的方法都会在初始化 / 销毁时被执行。
	 * 
	 */
	@PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy"); 
    }
}
