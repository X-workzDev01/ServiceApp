package com.serviceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviceApp.entity.RegistrationEntity;

public interface RegistrationRepository extends JpaRepository<RegistrationEntity, Integer> {

	RegistrationEntity findByCompanyName(String companyName);
	
	RegistrationEntity findByEmailId(String emailId);

}
