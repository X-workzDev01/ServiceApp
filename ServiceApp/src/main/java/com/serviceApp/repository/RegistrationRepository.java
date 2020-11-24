package com.serviceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviceApp.entity.RegistrationEntity;

public interface RegistrationRepository extends JpaRepository<RegistrationEntity, String> {

	RegistrationEntity findByCompanyName(String companyName);
	
	RegistrationEntity findByEmailId(String emailId);
	

}
