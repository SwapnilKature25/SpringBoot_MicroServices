package com.it.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.it.entity.User;
import com.it.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String index(Model model) {
		User userObject = new User();
		// this dummy data will be shown by default in form fields ( it will be taken care by binding object )
		// userObject.setFullName("Ashok S");
		model.addAttribute("user",userObject);
//		model.addAttribute("user",new User());
		return "index";
	}
	
//	Disptacher servlet will take the data from form and store it in our user object
	@PostMapping("/saveUser")
	public String handleSubmitButton(User user,Model model ) {
		boolean saveUser = userService.saveUser(user);
		if(saveUser) {
			model.addAttribute("smsg","User Saved Successfully...");
		} else {
			model.addAttribute("emsg","Fialed to save User");			
		}
		
		return "index";
	}
	
	
	
}
