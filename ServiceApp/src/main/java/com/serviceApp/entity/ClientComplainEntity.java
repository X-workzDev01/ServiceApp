package com.serviceApp.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "ClientComplain")
public class ClientComplainEntity {

	@Id
	private String complaintId;
	private String model;
	private String serialNo;
	private String mcType;
	private String problem;
	private String status;
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "companyName")
	@JsonBackReference
	RegistrationEntity registration;
	
	public ClientComplainEntity() {
		System.out.println("invoking " + this.getClass().getSimpleName());
	}

	@Override
	public String toString() {
		return "ClientComplainEntity [ticket=" + complaintId + ", model=" + model + ", serialNo=" + serialNo + ", mcType="
				+ mcType + ", problem=" + problem + ", status=" + status + ", date=" + date + "]";
	}
}