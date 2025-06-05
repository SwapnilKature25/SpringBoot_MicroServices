package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.it.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("/product")
	public String getProductName(Model model)
	{
		model.addAttribute("msg","This is Samsung laptop");
		String s=null;
		s.length();
		return "index";
	}
}
