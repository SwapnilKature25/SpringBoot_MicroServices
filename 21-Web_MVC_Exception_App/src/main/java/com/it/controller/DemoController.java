package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
	
	@GetMapping("/welcome")
	public String getWelcomeMsg(Model model) {
		model.addAttribute("msg","Welcome to Ashok it");
		int i=1/0;
		return "index";
	}
	
	@GetMapping("/greet")
	public String getGreetMsg(Model model) {
		model.addAttribute("msg","Good Morning");
		return "index";
	}
	
//	Local Exception Handler
//	@ExceptionHandler(value=Exception.class)
//	public String handleException(Exception e)
//	{
//		System.out.println(e.getMessage());
//		return "errorView";
//	}
 
}
