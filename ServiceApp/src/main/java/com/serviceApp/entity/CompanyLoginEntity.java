package com.serviceApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "companylogin")
public class CompanyLoginEntity {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id;
	private String emailId;
	private String password;

	
	public CompanyLoginEntity() {
		System.out.println("invoking "+this.getClass().getSimpleName());
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String email) {
		this.emailId = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CompanyLogin [email=" + emailId + ", password=" + password + "]";
	}
	
}
