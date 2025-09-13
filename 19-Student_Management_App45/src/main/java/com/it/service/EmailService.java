package com.it.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.it.Application;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    private final Application application;
	
	@Autowired
	private JavaMailSender mailSender;

    EmailService(Application application) {
        this.application = application;
    }
	
	public void sendEmail(String subject, String body, String to) {
		// if smtp server is down there is a chance of getting exception
		try {
			SimpleMailMessage msg=new SimpleMailMessage();
			msg.setSubject(subject);
			msg.setText(body);
			msg.setTo(to);
			
			mailSender.send(msg);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void sendEmail2(String subject, String body, String to) {
		// if smtp server is down there is a chance of getting exception
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			// if we want to add attachement to MimeMessage we need to set attribute as true
			MimeMessageHelper helper=new MimeMessageHelper(mimeMessage, true);  
			helper.setSubject(subject);
			helper.setText(body,true);   // if we want to process html tags then make it true
			helper.setTo(to);
//			helper.setCc();
			helper.addAttachment("Spring-core-notes.txt", new File("C:\\Users\\swapn\\Downloads\\Telegram Desktop\\Spring-core-notes.txt"));
			
			mailSender.send(mimeMessage);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
