package com.it.beans;

public class PetrolEngine implements IEngine
{
	public PetrolEngine() {
		System.out.println("PetrolEngine.PetrolEngine()");
	}
	
	@Override
	public int start() {
		System.out.println("Petrol engine started");
		return 1;
	}

}
