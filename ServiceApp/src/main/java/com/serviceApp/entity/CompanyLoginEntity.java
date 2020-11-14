package com.serviceApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.serviceApp.DTO.RegistrationDTO;

@Entity
@Table (name = "companylogin")
public class CompanyLoginEntity {

	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id;
	@NotNull @Email
	private String email;
	@NotNull @Size(min = 8 , max = 8 , message = "password should be only 8 character")
	private String password;

	Logger logger = LoggerFactory.getLogger(CompanyLoginEntity.class);
	
	public CompanyLoginEntity() {
		logger.info("invoking "+this.getClass().getSimpleName());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "CompanyLogin [email=" + email + ", password=" + password + "]";
	}
	
}
