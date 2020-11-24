package com.serviceApp.entity;

import java.util.Date;

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
@Table(name = "ClientComplain")
public class ClientComplainEntity {

	@Id
	private String ticket;
	private String model;
	private String serialNo;
	private String mcType;
	private String problem;
	private String status;
	private Date date;
	private String companyName;
	
	public ClientComplainEntity() {
		System.out.println("invoking " + this.getClass().getSimpleName());
	}
}