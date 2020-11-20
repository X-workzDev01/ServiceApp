package com.serviceApp.dto;

import javax.validation.constraints.NotNull;

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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getMcType() {
		return mcType;
	}

	public void setMcType(String mcType) {
		this.mcType = mcType;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	@Override
	public String toString() {
		return "ClientComplainDTO [companyName=" + companyName + ", model=" + model + ", serialNo=" + serialNo
				+ ", mcType=" + mcType + ", problem=" + problem + "]";
	}
}
