package com.it.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {

	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		String msg="Welcome to REST API....";
		return msg;
	}
	
}
