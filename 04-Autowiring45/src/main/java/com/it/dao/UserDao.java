package com.it.dao;

import org.springframework.stereotype.Component;

@Component
public class UserDao {
	public UserDao() {
		System.out.println("UserDao.UserDao()");
	}
	
	public String findUserNameById(int id) {
		if(id==1) {
			return "raju";
		} else if(id==2) {
			return "rani";
		}else {
			return "Invalid id";
		}
	}
}
