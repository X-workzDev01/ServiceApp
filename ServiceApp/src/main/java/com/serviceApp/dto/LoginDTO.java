package com.serviceApp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginDTO {

	@NotNull @Email
	private String emailId;
	@NotNull @Size(min = 8 , max = 8 , message = "password should be only 8 character")
	private String password;

	Logger logger = LoggerFactory.getLogger(getClass());

	public LoginDTO() {
		logger.info("invoking " + this.getClass().getSimpleName());
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "ClientLogin [emailId=" + emailId + ", password=" + password + "]";
	}

}
