package com.it.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.it.beans.ATM;
// make it as maven project by adding archetye as maven-archetype-quickstart
public class Test {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
		ATM atm = context.getBean(ATM.class);
		atm.withdraw(1000);
		
	}
}
