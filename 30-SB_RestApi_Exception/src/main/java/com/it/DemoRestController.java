package com.it;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoRestController {
	
	@GetMapping("/demo")
	public String getWelcomeMsg() {
		String s=null;
		s.length();
		String msg="Welcome to Hyd";
		return msg;
	}
}
