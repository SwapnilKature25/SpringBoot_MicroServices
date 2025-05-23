package com.it.driver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.it.beans.Motor;
import com.it.config.AppConfig;

public class MainApp {
	public static void main(String[] args) {
		
		// xml 
//		ApplicationContext context=new ClassPathXmlApplicationContext(Beans.xml);		
		
		// annotations
		@SuppressWarnings("resource")
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		
		Motor m1=context.getBean(Motor.class);
		System.out.println(m1.hashCode());   // 555273695

		Motor m2=context.getBean(Motor.class);
		System.out.println(m2.hashCode());  // 555273695
		
		
	}
}
