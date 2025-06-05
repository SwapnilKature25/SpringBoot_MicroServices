package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MsgController {
	
	@GetMapping("/welcome")
	public String getWelcomeMsg(Model model) {
		model.addAttribute("msg","Spring Web MVC appl with JSP as presentation technology");
		return "index";
	}
}
