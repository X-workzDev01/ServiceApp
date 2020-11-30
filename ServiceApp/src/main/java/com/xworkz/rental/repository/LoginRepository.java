package com.xworkz.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.xworkz.rental.entity.CompanyLoginEntity;

public interface LoginRepository extends JpaRepository<CompanyLoginEntity, Integer> {

	CompanyLoginEntity findByEmailId(String emailId);

	/*
	 * @Query(value = "select EMAIL_ID from COMPANYLOGIN lg where lg.ROLE= :role",
	 * nativeQuery = true) List<String> findByRole(String role);
	 */

	CompanyLoginEntity findByRole(String role);
	
	List<CompanyLoginEntity> findAllByRole(String role);
	//CompanyLoginEntity findByRole(String string);

}
