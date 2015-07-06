package com.fayuan.web.dao.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.fayuan.web.dao.BaseDao;
import com.fayuan.web.model.User;

@Repository
public class UserDaoImpl extends BaseDao<User> {

	@Value("${db.username}")
	private String username;
		
	@Override
	public boolean save(User t) {		
		super.save(t);
		
		System.out.println("username = " + username);
		
		System.out.println("save user success");
		return true;		
	}	
}
