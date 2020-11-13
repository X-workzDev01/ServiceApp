package com.serviceApp.utility.mailSender;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class JMS {
	
	@Autowired
	private JavaMailSender mailSender;

	// function for sending mail
	public void sendMail(String email) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("kunj.hasi103@gmail.com");
		message.setTo(email);
		message.setSubject("serviceapp registeration");
		message.setText("Your Registration for ServiceApp is Successful");
		
		mailSender.send(message);
		
	}
}
