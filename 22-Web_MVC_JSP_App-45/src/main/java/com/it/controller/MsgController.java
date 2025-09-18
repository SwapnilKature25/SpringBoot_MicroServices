package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MsgController {
	
	@GetMapping("/welcome")
	public String getWelcomeMsg(Model model) {
		model.addAttribute("msg","Good Morning");
		return "index";
	}
	
	@PostMapping("/login")
	public String login(HttpServletRequest req, Model model) {
		
		// If login success then store userId in session
		HttpSession session = req.getSession(true);  // means new session object will be created
//		session.setAttribute("userId", userId);
		session.setMaxInactiveInterval(60);   // if for 60 seconds we dont use the appl then our session will become invalidate
		return "index";
	}

	@GetMapping("/orders")
	public String orders(HttpServletRequest req, Model model) {
		
		HttpSession session = req.getSession(true);  
		// get the userId which we have stored at the time of session object creation
		Integer userId=(Integer)session.getAttribute("userId");
		// based on userId get orders
		return "index";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req, Model model) {
		
		// get existing session object
		HttpSession session = req.getSession(true);  // means existing session object will be called
		session.invalidate();   // invalidate means we are going to remove that session object
		
		return "index";
	}
	
}
