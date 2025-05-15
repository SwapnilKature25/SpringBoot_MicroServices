package com.it.beans;

public class Car {
	private IEngine eng;
	
	public Car() {
		System.out.println("Car.Car()::no parameterized const");
	}
	
	public Car(IEngine eng)
	{
		System.out.println("Car.Car()::parameterized const");
		this.eng=eng;
	}
	
	// setter injection
	public void setEng(IEngine eng)
	{
		System.out.println("setEng() method called...");
		this.eng=eng;
	}
	
	
	public void drive()
	{
		int status=eng.start();
		if(status>=1)
			System.out.println("Journey started");
		else 
			System.out.println("Engine trouble");
	}
}
