package com.it.dao;

import org.springframework.stereotype.Component;

@Component
public interface UserDao {
	
	public String findUserNameById(int id);
	
}
