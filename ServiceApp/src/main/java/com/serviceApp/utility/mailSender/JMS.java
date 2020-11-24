package com.serviceApp.utility.mailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.serviceApp.entity.ClientComplainEntity;

@Component
public class JMS {
	
	@Autowired
	private JavaMailSender mailSender;

	// function for sending mail
	public void sendMail(String emailId, String password) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("xworkzodc01@gmail.com");
		message.setTo(emailId);
		message.setSubject("serviceapp registeration");
		message.setText("Your Registration for ServiceApp is Successful. Your credentials are \n Email :"+ emailId +" \n Password : " + password);
		
		mailSender.send(message);
		
	}
}
