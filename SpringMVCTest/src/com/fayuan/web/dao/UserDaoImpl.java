package com.fayuan.web.dao;

import org.springframework.stereotype.Repository;

import com.fayuan.web.dao.impl.BaseDao;
import com.fayuan.web.model.User;

@Repository
public class UserDaoImpl extends BaseDao<User> {

	@Override
	public boolean save(User t) {		
		super.save(t);
		
		System.out.println("save user success");
		return true;		
	}	
}
