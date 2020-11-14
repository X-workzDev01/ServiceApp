package com.serviceApp.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.serviceApp.controller.ClientLoginController;

public class ClientLoginDTO {

	@NotNull @Email
	private String emailId;
	@NotNull
	private String password;

	Logger logger = LoggerFactory.getLogger(ClientLoginDTO.class);
	
	public ClientLoginDTO() {
		logger.info("invoking "+this.getClass().getSimpleName());
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
