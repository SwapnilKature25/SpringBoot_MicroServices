package com.it;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.it.dao.UserDao;
import com.it.service.UserService;

@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
				
		UserDao dao1 = context.getBean(UserDao.class);
		System.out.println(dao1.hashCode());
		
		UserDao dao2 = context.getBean(UserDao.class);
		System.out.println(dao2.hashCode());
		
		System.out.println();
		
		UserService ser1 = context.getBean(UserService.class);
		UserService ser2 = context.getBean(UserService.class);
		
		System.out.println(ser1.hashCode());
		System.out.println(ser2.hashCode());
		
	}

}

/*
singleton scope
1831705084
1831705084

prototype
UserService.UserService()
UserService.UserService()
569976699
538618049

*/
