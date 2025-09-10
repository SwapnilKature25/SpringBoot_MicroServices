package com.it.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.it.dao.UserDao;

@Component
@Scope("prototype")
public class UserService {
	
	public UserService() {
		System.out.println("UserService.UserService()");
	}
	
}
