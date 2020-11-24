package com.serviceApp.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "Registration")
public class RegistrationEntity {

	@Id
	private String companyName;
	private String customerName;
	private String emailId;
	private long contactNumber;
	private String address;
	private String password;
	
	
	public RegistrationEntity() {
		System.out.println("invoking "+this.getClass().getSimpleName());
	}
}
