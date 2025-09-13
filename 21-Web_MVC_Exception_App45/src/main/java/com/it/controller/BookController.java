package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
	
	@GetMapping("/book")
	public String bookData(Model model) {
		int i=10/0;
		model.addAttribute("msg","Java Books are not available");
		return "index";
	}
}
