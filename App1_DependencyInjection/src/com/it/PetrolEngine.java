package com.it;

public class PetrolEngine implements IEngine
{

	@Override
	public int start() {
		System.out.println("Petrol engine started");
		return 1;
	}

}
