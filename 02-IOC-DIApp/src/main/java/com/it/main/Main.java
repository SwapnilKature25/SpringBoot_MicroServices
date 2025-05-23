package com.it.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.it.beans.Car;
import com.it.beans.PetrolEngine;

public class Main {
	public static void main(String[] args) {
		// starting IOC container
	    // called as lazy loading
		System.out.println("=============BeanFactory started============");
//		BeanFactory factory=new XmlBeanFactory(new ClassPathResource("Beans.xml"));  // XmlBeanFactory has been deprecated and removed from spring 5v
//		Car car = factory.getBean(Car.class);
		
		/*
		 * we can call Bean factory as a lazy loading because it is executing after calling getBean() 
		 * only it is creating object for the class otherwise it's not creating any object
		 * */
	
		// called as eager loading
//		singleton bean objects are creating at the time of starting 
		System.out.println("=============ApplicationContext started============");
		ApplicationContext context=new ClassPathXmlApplicationContext("Beans.xml");  
		
//		car obj created on demand basis i.e when i call it
//		prototype bean obj are creating on demand basis
		Car bean = context.getBean(Car.class);
		bean.drive();
//		here from above we can say that ApplicationContext is following eager loading for singleton scope and lazy loading for prototype scope
	
	
		// Singleton   -> if the scope is singleton then it all will return same hashcode
		// prototype   -> if the scope is prototype then it all will return diff hashcode
		PetrolEngine p1 = context.getBean(PetrolEngine.class);	
		System.out.println(p1.hashCode());
		
		PetrolEngine p2 = context.getBean(PetrolEngine.class);	
		System.out.println(p2.hashCode());
		
		PetrolEngine p3 = context.getBean(PetrolEngine.class);	
		System.out.println(p3.hashCode());
	}
}
