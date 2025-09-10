package com.it.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("oracle")
@Primary
public class OracleUserDaoImpl implements UserDao{
	
	public OracleUserDaoImpl() {
		System.out.println("OracleUserDaoImpl -- constructor");
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
