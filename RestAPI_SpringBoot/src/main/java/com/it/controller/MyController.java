package com.it.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.entity.Course;

@RestController   // REST => Representational state transfer
public class MyController {
	 
	// Get All Courses
	@GetMapping("/home")
	public List<Course> getCoursess() {
		
		return null;
	}
}
