package com.it.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.it.controller.MsgController;
// Gloable Exception handler

// for web appl controllerAdvice
@ControllerAdvice		// to make it as Gloable Exception handler use this annotation
@RestControllerAdvice   // for Rest API rest controller advice
public class AppExceptionHandler {   // whenever exception is going to occur this method will handle it

	// logger is used to generate log msg and logging is used to understand runtime behaviour of the application.
	private Logger logger=LoggerFactory.getLogger(MsgController.class);
	

	// Custom exception
	@ExceptionHandler(value=ProductNotFoundException.class)
	public String handleProductException(ProductNotFoundException e, Model model) {
		logger.error(e.getMessage());
		model.addAttribute("msg","No Product found");
		return "errorPage";   // see in console
	}

	@ExceptionHandler(value=ArithmeticException.class)
	public String handleAEException(ArithmeticException e,Model model) {
		logger.error(e.getMessage());
		model.addAttribute("msg","Divide by / 0 not allowed");		
		return "errorPage";
	}

	@ExceptionHandler(value=NullPointerException.class)
	public String handleNPEException(NullPointerException e) {
		logger.error(e.getMessage());
		return "errorPage";
	}
	
	@ExceptionHandler(value=Exception.class)
	public String handleException(Exception e, Model model) {
		
		// if we dont want multiple methods then we can execute all specialized method in single method
		/*
		if(e instanceof NullPointerException) {
			
		} else if(e instanceof ArithmeticException) {
			
		}.e..e.
		*/
		
		logger.error(e.getMessage());
		model.addAttribute("msg","Some problem Occured");
		return "errorPage";
	}
}
