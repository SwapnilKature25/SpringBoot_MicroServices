package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import com.it.dao.UserDao;
import com.it.service.UserService;

@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		UserService bean = context.getBean(UserService.class);
		bean.getName(1);
		
	}

}

/*
if we pass bean name to component of MySQLUserDaoImpl @Component("userDao")
MySQLUserDaoImpl -- constructor
OracleUserDaoImpl -- constructor
com.it.dao.MySQLUserDaoImpl
raju


if we go with constructor injection
MySQLUserDaoImpl -- constructor
OracleUserDaoImpl -- constructor
com.it.dao.OracleUserDaoImpl
raju

*/
