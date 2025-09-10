package com.it.beans;

public class UserController {
	
	private UserService userService;
	
	public UserController(UserService userService) {
		System.out.println("UserController.UserController()");
		this.userService=userService;
	}
	
	public void register() {
		userService.userRegistration();
	}
}
