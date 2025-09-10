package com.it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.it.dao.UserDao;

@Component
public class UserService {
	
//	@Autowired
//	@Qualifier("mysql")
	private UserDao userDao;

	public UserService(UserDao oracle) {
		this.userDao=oracle;
	}
	
	public void getName(int id) {
		String name = userDao.findUserNameById(id);
		System.out.println(userDao.getClass().getName());
		System.out.println(name);
	}
	 
}
