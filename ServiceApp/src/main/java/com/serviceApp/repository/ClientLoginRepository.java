package com.serviceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviceApp.DTO.ClientLoginDTO;
import com.serviceApp.entity.RegistrationEntity;

public interface ClientLoginRepository extends JpaRepository<RegistrationEntity, Integer>{

	RegistrationEntity findByEmail(String emailId);

}
