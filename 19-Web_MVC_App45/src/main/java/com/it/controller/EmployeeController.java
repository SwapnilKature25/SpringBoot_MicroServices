package com.it.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.it.model.Employee;
import com.it.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public ModelAndView getAllEmps() {
		List<Employee> allEmps = employeeService.getAllEmps();
		ModelAndView  mav=new ModelAndView();
		mav.addObject("employees",allEmps);
		mav.setViewName("employee");
		return mav;
	}
}
