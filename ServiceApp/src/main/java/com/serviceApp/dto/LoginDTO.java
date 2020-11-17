package com.serviceApp.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginDTO {

//	@NotNull @Email
	private String emailId;
	// @NotNull
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
