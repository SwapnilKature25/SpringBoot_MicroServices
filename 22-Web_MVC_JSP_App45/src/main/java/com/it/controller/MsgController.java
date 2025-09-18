package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MsgController {
	
	@GetMapping("/welcome")
	public String getMethodName(Model model) {
		model.addAttribute("msg","Good Morning");
		return "index";
	}
	
}
