package com.it.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.it.beans.Motor;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Spring-Beans.xml");
		Motor motor = context.getBean(Motor.class);
		motor.doWork();
		
		ConfigurableApplicationContext cfgCtx = (ConfigurableApplicationContext) context;
		cfgCtx.registerShutdownHook();
		
	}
}
