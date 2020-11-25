package com.serviceApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.serviceApp.entity.ClientComplainEntity;

public interface ComplainRepository extends JpaRepository<ClientComplainEntity, String> {
	// change this to sql query

	//@Query(value = "select COMPANY_NAME from CLIENT_COMPLAIN  as company inner join REGISTRATION as reg where reg.companyName= :companyName", nativeQuery = true)
	@Query(value = "select company.COMPANY_NAME from CLIENT_COMPLAIN  as company inner join REGISTRATION as reg where reg.COMPANY_NAME= :companyName", nativeQuery = true)
	List<ClientComplainEntity> findAllByCompanyName(String companyName);

}
