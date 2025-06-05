package com.it.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// to represent it has a global exception handler we use below annotation
@ControllerAdvice   // means Exception Handler 
public class AppExceptionHandler {
	
//	Exception.class : It should execute for any type of exception occured in our project
	@ExceptionHandler(value=Exception.class)
	public String handleException(Exception e)
	{
		System.out.println(e.getMessage());
		return "errorView";
	}
}
