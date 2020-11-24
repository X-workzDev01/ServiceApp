package com.serviceApp.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.serviceApp.entity.RegistrationEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClientComplainDTO {

	@NotNull
	private String companyName;
	@NotNull
	private String model;
	@NotNull
	private String serialNo;
	@NotNull
	private String mcType;
	@NotNull
	private String problem;

	public ClientComplainDTO() {
		System.out.println("invooking " + this.getClass().getSimpleName());
	}
}
