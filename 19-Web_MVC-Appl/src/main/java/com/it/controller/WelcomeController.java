package com.it.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.it.Application;

// Controller is called request handler
@Controller   // to represent our java class as a spring controller
@RequestMapping("/c1")
public class WelcomeController {

    private final Application application;

	public WelcomeController(Application application) {
		System.out.println("WelcomeController.WelcomeController():: Constructor");
		this.application = application;
	}
	
//	 whenever we send get request with welcome parameter this method will be calledd	
	@GetMapping("/welcome")   // means it is a doGet(), it is responsible to handle get request
	public ModelAndView getWelcomeMsg() {
		System.out.println("WelcomeController.getWelcomeMsg() :: method executed");
		ModelAndView mav=new ModelAndView();
		mav.addObject("msg1","Welcome to Ashok IT");  // Model represents data in key-value pair
		mav.addObject("msg2","Good morning");

//		we are returning index view name so there should be index.html file present in project
		mav.setViewName("index");  // whenever request comes to this method, this method Should send reponse to index.html page in project.
//		whenever request comes to this controller it will execute the logic and will return index page as response.
		return mav;
	}
	
//	mapping method to url pattern
	@GetMapping("/date")
	public ModelAndView getDate()
	{
		ModelAndView mav=new ModelAndView();
		mav.addObject("date",new Date());	
		mav.setViewName("index");
		return mav;
	}
	
}
