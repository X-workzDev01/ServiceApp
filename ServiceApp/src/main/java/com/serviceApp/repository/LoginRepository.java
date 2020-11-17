package com.serviceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviceApp.entity.CompanyLoginEntity;

public interface LoginRepository extends JpaRepository<CompanyLoginEntity, Integer> {

	CompanyLoginEntity findByEmailId(String emailId);

}
