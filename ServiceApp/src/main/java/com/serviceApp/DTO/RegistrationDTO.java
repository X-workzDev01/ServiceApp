package com.serviceApp.DTO;

public class RegistrationDTO {

	private String customerName;
	private String companyName;
	private String email;
	private long contactNumber;
	private String address;

	public RegistrationDTO() {
		System.out.println("invoking " + this.getClass().getSimpleName());
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
