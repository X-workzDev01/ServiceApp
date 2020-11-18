package com.serviceApp.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistrationDTO {

	@NotNull
	private String customerName;
	@NotNull
	private String companyName;
	@NotNull @Email
	private String emailId;
	@NotNull @Size(min = 9 , max = 12)
	private long contactNumber;
	@NotNull
	private String address;

	Logger logger = LoggerFactory.getLogger(RegistrationDTO.class);
	
	public RegistrationDTO() {
		logger.info("invoking "+this.getClass().getSimpleName());
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String email) {
		this.emailId = email;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "RegistrationDTO [customerName=" + customerName + ", companyName=" + companyName + ", email=" + emailId
				+ ", contactNumber=" + contactNumber + ", address=" + address + "]";
	}

}
