package com.serviceApp.utility.mailSender;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

@Component
public class JavaMailSender {
	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(String emailId) {
		// creating message
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("kunj.hasi103@gmail.com");
		message.setTo(emailId);
		message.setSubject("Registration Successful");
		message.setText("Your Registration for ServiceApp is Successful");
		// sending message
		mailSender.send(message);
	}

}
