package com.serviceApp.DTO;

public class ClientLoginDTO {

	private String emailId;
	private String password;

	public ClientLoginDTO() {
		System.out.println("invoking "+this.getClass().getSimpleName());
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
