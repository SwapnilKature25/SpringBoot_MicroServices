package com.it.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MsgController {
	
	// logger is used to generate log msg and logging is used to understand runtime behaviour of the application.
	private Logger logger=LoggerFactory.getLogger(MsgController.class);
	
	@GetMapping("/welcome")
	public String getWelcomeMsg(Model model) {   // model is used to send data from controller to ui in the form of key and value.
		int i=10/0;
		model.addAttribute("msg","Welcome to Ashok it");
		return "index";
	}

	@GetMapping("/greet")
	public String getGreetMsg(Model model) {   // model is used to send data from controller to ui in the form of key and value.
		model.addAttribute("msg","Good Morning");
		return "index";
	}
	
//	Controller base Handling example
//	@ExceptionHandler(value=Exception.class)
//	public String handleException(Exception e) {
//		logger.error(e.getMessage());
//		return "errorPage";
//	}
	
}
