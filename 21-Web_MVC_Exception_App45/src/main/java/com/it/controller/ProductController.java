package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.it.exception.AppExceptionHandler;
import com.it.exception.ProductNotFoundException;

@Controller
public class ProductController {

    private final AppExceptionHandler appExceptionHandler;

    ProductController(AppExceptionHandler appExceptionHandler) {
        this.appExceptionHandler = appExceptionHandler;
    }
	
    // http://localhost:8080/product?pid=2     => No Record Found
    // http://localhost:8080/product?pid=1     => Product Name : Apple
	@GetMapping("/product")
	public String getProduct(@RequestParam("pid") Integer pid, Model model) {
	
		if(pid==1) {
			model.addAttribute("msg","Product Name : Apple");
		}
		else {
			throw new ProductNotFoundException("No Record Found");
		}
		return "index";
	}
	
}
