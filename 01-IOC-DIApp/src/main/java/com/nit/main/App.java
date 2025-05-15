package com.nit.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.it.beans.Car;

public class App {
	public static void main(String[] args) {
		
		// starting IOC Container
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		
		// getting bean object from IOC container
		Car car=context.getBean(Car.class);
		car.drive();
				
		
	}
}
