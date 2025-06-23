package com.it.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.it.beans.Car;
import com.it.beans.PetrolEngine;

public class Main {
	public static void main(String[] args) {
		// starting IOC container
		// Load the Spring XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

        // Get the Car bean from container
        Car car = context.getBean("car", Car.class);

        // Use the bean
         car.drive();
	}
}
