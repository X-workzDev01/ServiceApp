
package com.serviceApp.DTO;

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
	private String email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		return "RegistrationDTO [customerName=" + customerName + ", companyName=" + companyName + ", email=" + email
				+ ", contactNumber=" + contactNumber + ", address=" + address + "]";
	}

}
