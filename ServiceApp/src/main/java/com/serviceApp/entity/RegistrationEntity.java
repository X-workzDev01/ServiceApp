package com.serviceApp.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Registration")
public class RegistrationEntity {

	@Id
	private String companyName;
	private String customerName;
	private String emailId;
	private long contactNumber;
	private String address;
	private String password;
	
	@OneToMany(mappedBy = "registration")
	@JsonManagedReference
	Set<ClientComplainEntity> clientComplainEntities ;
	
	public RegistrationEntity() {
		System.out.println("invoking "+this.getClass().getSimpleName());
	}

	@Override
	public String toString() {
		return "RegistrationEntity [companyName=" + companyName + ", customerName=" + customerName + ", emailId="
				+ emailId + ", contactNumber=" + contactNumber + ", address=" + address + ", password=" + password
				+ "]";
	}
}
