package com.it;

public class Car2 {
	private IEngine eng;
	
//	constructor injection - CI
//	public Car2(IEngine eng)
//	{
//		this.eng=eng;
//	}
	
//	setter injection  - SI
//	public void setEng(IEngine eng)
//	{
//		this.eng=eng;
//	}
	
	public void drive()
	{
		int start=eng.start();
		if(start>=1)
		{
			System.out.println("Journey started");
		}
		else 
			System.out.println("Engine in trouble...");
	}
}
