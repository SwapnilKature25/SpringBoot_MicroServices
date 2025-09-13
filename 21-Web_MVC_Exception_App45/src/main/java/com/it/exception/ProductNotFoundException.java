package com.it.exception;

public class ProductNotFoundException extends RuntimeException
{
	public ProductNotFoundException(String msg) {
		super(msg);
	}
}
