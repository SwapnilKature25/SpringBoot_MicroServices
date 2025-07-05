package com.it;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {
	
	@GetMapping("/welcome")
	public String getWelcomeMsg() {
		int i=10/0;
		String msg="Welcome to Hyd";
		return msg;
	}
	
//	@ExceptionHandler(value=Exception.class)
//	public ResponseEntity<String> handleAE(Exception e)
//	{
//		return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//	}
}
