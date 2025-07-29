package com.nit.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.it.beans.Car;

public class App {
	public static void main(String[] args) {
	
		// starting Beanfactory (outdated)
//		BeanFactory factory =new XmlBeanFactory("beans.xml");
		
		// starting IOC Container
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		
		// getting bean object from IOC container
		Car car=context.getBean(Car.class);
		car.drive();
				
		
	}
}

/*

DieselEngine.DieselEngine()
PetrolEngine.PetrolEngine()
Constructor Injection called with: DieselEngine
Setter Injection called with: com.it.beans.PetrolEngine
Petrol engine started
Journey started


*/