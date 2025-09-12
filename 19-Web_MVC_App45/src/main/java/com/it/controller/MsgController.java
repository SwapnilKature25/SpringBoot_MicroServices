package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class MsgController {
	
	public MsgController() {
		System.out.println("MsgController.MsgController()");
	}
	
	// Endpoint: /user/greet
	@GetMapping("/greet")
	public ModelAndView getGreetMsg() {
		ModelAndView mav=new ModelAndView();
		
		// set data to model in k-v format
		mav.addObject("msg","Good Morning!!");
		
		// set view page name
		mav.setViewName("index");
		
		return mav;
	}
	
	
	
	@GetMapping("/welcome")
	public ModelAndView getWelcomeMsg() {
		ModelAndView mav=new ModelAndView();
		
		// setting data in the form of key-value pair
		mav.addObject("msg","welcome Swap"); // model in the form key and value
		
		// setting view name
		mav.setViewName("index");
		return mav;
	}
}	
