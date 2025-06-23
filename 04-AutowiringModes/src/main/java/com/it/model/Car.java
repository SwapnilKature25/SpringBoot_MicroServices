package com.it.model;

public class Car {
	private Engine engine;

//	A. For no, byName, and byType (Setter Injection):
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void drive() {
		engine.start();
		System.out.println("Car is running...");
	}
}
