package com.it.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.it.beans.Car;
import com.it.beans.PetrolEngine;

public class Main {
	public static void main(String[] args) {
		// starting IOC container
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");
		Car car = context.getBean(Car.class);
		car.drive();
	}
}
