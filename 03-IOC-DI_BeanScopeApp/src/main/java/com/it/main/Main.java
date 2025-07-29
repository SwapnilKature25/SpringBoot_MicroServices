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

/*

1. byName
DieselEngine.DieselEngine()
PetrolEngine.PetrolEngine()
Car.Car()::no parameterized const
Setter method : setEng() method called...
Petrol engine started
Journey started


2. byType
DieselEngine.DieselEngine()
PetrolEngine.PetrolEngine()
Car.Car()::no parameterized const
Setter method : setEng() method called...
Diesel engine started
Journey started

2. constructor
DieselEngine.DieselEngine()
PetrolEngine.PetrolEngine()
Car.Car()::parameterized const
Diesel engine started
Journey started



*/
