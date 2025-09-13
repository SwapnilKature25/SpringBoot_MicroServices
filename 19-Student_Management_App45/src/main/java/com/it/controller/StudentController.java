package com.it.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.it.entity.Student;
import com.it.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService service;
	
	public StudentController(StudentService service) {
		this.service=service;
	}
	
//	1st way
//   method to display empty form
	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView mav=new ModelAndView();
		mav.setViewName("index");
		return mav;
	}

//	2nd way
	@GetMapping("/student")
	public String loadForm(Model model) {
		model.addAttribute("msg","Model component");
		return "index";
	}
	
	// method to save student form data
	@RequestMapping("/saveStudent")
	public ModelAndView handleSubmitBtn(Student s) {
		ModelAndView mav=new ModelAndView();
		boolean isSaved = service.saveStudent(s);
		if(isSaved) {
			mav.addObject("success","Student saved");
		}
		else {
			mav.addObject("err","Failed To Save");
		}
		mav.setViewName("index");
		return mav;
	}
	
	// method to get all students data
	@GetMapping("/getData")
	public ModelAndView getAllStudents(Student s) {
		ModelAndView mav=new ModelAndView();
		List<Student> studList = service.getAllStudents();
		mav.addObject("students",studList);
		
		mav.setViewName("data");
		return mav;
	}
	
//	@RequestParam("sid") to capture data from url
	@GetMapping("/delete")
	public ModelAndView deleteRecord(@RequestParam("sid") Integer sid) {
		service.deleteStd(sid);
		ModelAndView mav=new ModelAndView();
		List<Student> studList = service.getAllStudents();
		mav.addObject("students",studList);
		mav.addObject("msg","Deleted Successfully");
		mav.setViewName("data");
		return mav;
	}
	
	
	
	
}
