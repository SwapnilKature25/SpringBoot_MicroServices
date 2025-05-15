package com.it.beans;

import org.springframework.stereotype.Component;

@Component
public class Car {
	public Car() {
		System.out.println("Car::constructor");
	}
}
