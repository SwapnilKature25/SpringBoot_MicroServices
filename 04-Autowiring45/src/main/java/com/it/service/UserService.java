package com.it.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.it.dao.UserDao;

@Component
@Scope("prototype")
public class UserService {
	
//	@Autowired
	private UserDao userDao;
	
//	@Autowired
	public void setDao(UserDao dao) {
		System.out.println("UserService.setDao() called ");
		this.userDao=dao;
	}
	
	public UserService() {
		System.out.println("UserService - no-constructor called ");
	}
	
	@Autowired    // optinal if no-param constructor is not there 
	public UserService(UserDao dao) {
		System.out.println("UserService - Param constructor called ");
		this.userDao=dao;
	}
	
	public void getName(int id) {
		String name = userDao.findUserNameById(id);
		System.out.println(name);
	}
	 
}
