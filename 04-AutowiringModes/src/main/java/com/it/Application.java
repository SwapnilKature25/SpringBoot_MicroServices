package com.it;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.it.model.Car;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");  
        Car car = context.getBean("car",Car.class);
        car.drive();
         //  run as -> java appl
	}

}
