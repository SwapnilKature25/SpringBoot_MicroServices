 package com.it.beans;

public class Car {
	
	private IEngine eng;

	
	public Car(IEngine eng) {
		super();
        System.out.println("Constructor Injection called with: " + eng.getClass().getSimpleName());
		this.eng = eng;
	}

	public void setEng(IEngine eng)
	{
        System.out.println("Setter Injection called with: " + eng.getClass().getName());
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
