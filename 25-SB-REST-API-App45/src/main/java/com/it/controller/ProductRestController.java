package com.it.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductRestController {
	
	// Query parameter
	@GetMapping("/product")
	public ResponseEntity<String> getProductInfo(@RequestParam("id") Integer id,
												 @RequestParam("name") String name){
		String msg="";
		if(id==101) {
			msg="Apple Mobile Price :: 85000 INR";
		}else if(id==102) {
			msg="Samsung Mobile Price :: 63000 INR";
		}else {
			msg="No Product Found";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}	

	// Path parameter    localhost:8080/product/101
	@GetMapping("/product/{id}")
	public ResponseEntity<String> getProductPrice(@PathVariable("id") Integer id){
		
		String msg="";
		if(id==101) {
			msg="Product Name :: Apple";
		}else if(id==102) {
			msg="Product Name :: Samsung";
		}else {
			msg="No Product Found";
		}
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}	
}
