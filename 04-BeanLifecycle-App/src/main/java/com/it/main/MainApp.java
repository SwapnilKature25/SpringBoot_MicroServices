package com.it.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.it.beans.Motor;

public class MainApp {
	public static void main(String[] args) throws Exception {
		ApplicationContext context=new ClassPathXmlApplicationContext("Spring-Beans.xml");
//		XMl approach
//		it will automatically call the predefined methods
//		Motor motor2 = context.getBean(Motor.class);
//		motor2.doWork();
//		it will stop the predefined interface method i.e destroy()
		ConfigurableApplicationContext cfgCtx = (ConfigurableApplicationContext) context;
		cfgCtx.registerShutdownHook();
		
//		Annotation based apporach
		Motor motor = context.getBean(Motor.class);
		motor.m1();
		motor.doWork();
		motor.m2();
		

	}
}
