package com.it.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgRestController {
	
	@GetMapping("/welcome/{name}")
	public ResponseEntity<String> getWelcomeMsg(@PathVariable("name") String name) {
		String msg=name+", Welcome to Rest API";
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
//	http://localhost:8080/greet?name=John
	@GetMapping("/greet")
	public String getGreetMsg(@RequestParam("name") String name) {
		String msg="Good Morning, "+name;
		return msg;
	}
	
	@GetMapping("/action")
	public ResponseEntity<Void> doAction() {
		System.out.println("MsgRestController.doAction() called");
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
