package com.it.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {
	
	@GetMapping("/msg")
	public String getMsg() {
		return "Welcome to spring security";
	}
	
	@GetMapping("/greet")
	public String getGreetMsg() {
		return "Goood Morning...";
	}
	 
	@GetMapping("/contact")
	public String contactUs() {
		return "Contact : 879878987";
	}
	
	
}
