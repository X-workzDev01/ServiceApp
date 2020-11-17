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
	//@NotNull @Email
	private String emailId;
	//@NotNull @Size(min = 8 , max = 8 , message = "password should be only 8 character")
	private String password;

	//Logger logger = LoggerFactory.getLogger(CompanyLoginEntity.class);
	
	public CompanyLoginEntity() {
		//logger.info("invoking "+this.getClass().getSimpleName());
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
