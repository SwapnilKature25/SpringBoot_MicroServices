package com.it.beans;

public class DieselEngine implements IEngine
{
	public DieselEngine() {
		System.out.println("DieselEngine.DieselEngine()");
	}
	
	@Override
	public int start() {
		System.out.println("Diesel engine started");
		return 1;
	}

}
