package com.it.dao;

import org.springframework.stereotype.Component;

@Component("mysql")   // bean name 
public class MySQLUserDaoImpl implements UserDao{
	
	public MySQLUserDaoImpl() {
		System.out.println("MySQLUserDaoImpl -- constructor");
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
