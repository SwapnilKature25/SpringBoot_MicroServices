package com.it;

public class Car extends Engine{
	public void drive()
	{
//		start the engine
//		Approach 1 
//		int start=super.start();
		
//		Approach 1 
		Engine eng=new Engine();
		int start = eng.start();
		
		if(start>=1)
		{
			System.out.println("Journey started");
		}
		
//		start the journey
	}
}
