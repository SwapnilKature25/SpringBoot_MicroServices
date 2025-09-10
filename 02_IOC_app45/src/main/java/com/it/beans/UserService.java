package com.it.beans;

public class UserService {

	private PwdService pwdService;
	private UserDao userDao;
	private EmailService emailService;
	
	public UserService() {
		System.out.println("UserService.UserService()");
	}
	
//	Alt+shift+S+R for setter
	public void setPwdService(PwdService pwdService) {
		this.pwdService = pwdService;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public void userRegistration() {
		// encrypt pswd
		pwdService.encrypt();
		
		// save user in db
		userDao.save();
		
		// send mail
		emailService.sendEmail();
	}
}
