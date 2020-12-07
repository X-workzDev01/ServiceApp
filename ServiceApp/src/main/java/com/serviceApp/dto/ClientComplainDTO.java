package com.serviceApp.dto;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

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
	@NotNull
	private String clientComment;

	Logger logger = LoggerFactory.getLogger(getClass());
	
	public ClientComplainDTO() {
		logger.info("invooking " + this.getClass().getSimpleName());
	}

	@Override
	public String toString() {
		return "ClientComplainDTO [companyName=" + companyName + ", model=" + model + ", serialNo=" + serialNo
				+ ", mcType=" + mcType + ", problem=" + problem + "]";
	}
}
