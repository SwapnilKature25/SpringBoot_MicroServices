package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody   // if we use this at class level then all the methods will return direct response.There will be no UI
@RequestMapping("/api")  // to solve ambiguity problem
public class MsgController {
	
	// if we return in one method as index page in another as content then spring boot sees both method returning view page name only.
	@GetMapping("/")
	public String getIndexPage() {
		return "index";
	}

	// if we want to send direct reponse from the body then use @ResponseBody 
	@GetMapping("/welcome")
	@ResponseBody
	public String getWelcomeMsg() {
		return "welcome ashok";
	}
	
	
}
