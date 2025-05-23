package com.it;

import java.lang.reflect.Field;

public class MainClass {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws  Exception {
//		Car car=new Car();
//		car.drive();
		
//		PetrolEngine pe=new PetrolEngine();
//		Car2 car=new Car2(pe);
		
//		 creating target obj
//		Car2 car2=new Car2(pe);
		
//		injecting dependent obj into target through setter method
//		car2.setEng(pe);
//		car2.drive();
		
		// Using Reflection API  - With Reflection API we can access private variables outside of the class
		Class<?> clz = Class.forName("com.it.Car2");
		Field engField = clz.getDeclaredField("eng");
		engField.setAccessible(true);

		Object obj = clz.newInstance();
		Car2 carObj =  (Car2)obj;
		
//		injecting value to variable
		engField.set(carObj, new DieselEngine());
		carObj.drive();
		
	}
}
