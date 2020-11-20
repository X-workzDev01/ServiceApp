package com.serviceApp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CompanyGadgetLIstEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String emailId;
	private String model;
	private String serialNo;
	private String mcType;
	private String dateOfAssigne;
	private String status;

	public CompanyGadgetLIstEntity() {
		System.out.println();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public String getDateOfAssigne() {
		return dateOfAssigne;
	}

	public void setDateOfAssigne(String dateOfAssigne) {
		this.dateOfAssigne = dateOfAssigne;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CompanyGadgetLIstEntity [id=" + id + ", emailId=" + emailId + ", model=" + model + ", serialNo="
				+ serialNo + ", mcType=" + mcType + ", dateOfAssigne=" + dateOfAssigne + ", status=" + status + "]";
	}
}
