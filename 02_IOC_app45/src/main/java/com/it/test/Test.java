package com.it.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.it.beans.UserController;
import com.it.beans.UserService;

public class Test {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
//		UserService user = context.getBean(UserService.class);
//		user.userRegistration();
		
		UserController bean = context.getBean(UserController.class);
		bean.register();
		
	}
}
 