package com.serviceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviceApp.entity.RegistrationEntity;

public interface ClientLoginRepository extends JpaRepository<RegistrationEntity, Integer>{

	RegistrationEntity findByEmailId(String emailId);

}
