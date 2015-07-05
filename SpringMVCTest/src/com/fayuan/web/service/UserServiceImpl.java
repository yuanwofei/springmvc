package com.fayuan.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fayuan.web.dao.impl.BaseDao;
import com.fayuan.web.model.User;
import com.fayuan.web.service.impl.UserService;


@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	BaseDao<User> userDaoImpl;
	
	@Override
	public boolean saveUser(User user) {
		return userDaoImpl.save(user);
	}

}
