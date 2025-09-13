package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
	
	public ProductController() {
		System.out.println("ProductController.ProductController()");
	}
	
	@GetMapping("/product")
	public ModelAndView getProductPrice() {
		
		ModelAndView mav=new ModelAndView();
		
		// set data
		mav.addObject("price","Apple Mobile Price :: 65000 INR");
		// set view name
		mav.setViewName("productPage");
		return mav;
	}
	
}
