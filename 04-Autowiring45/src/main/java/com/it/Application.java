package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.it.dao.UserDao;
import com.it.service.UserService;

@SpringBootApplication
public class Application {

    private final UserDao userDao;

    Application(UserDao userDao) {
        this.userDao = userDao;
    }

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		UserService bean = context.getBean(UserService.class);
		bean.getName(1);
		
	}

}

/*
Field injection 
UserDao.UserDao()
UserService.UserService()
raju

Setter injection
UserDao.UserDao()
UserService.UserService()
UserService.setDao() called 
raju

constructor injection
UserDao.UserDao()
UserService - Param constructor called 
UserService.setDao() called 
raju

*/
