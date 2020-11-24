package com.serviceApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviceApp.entity.ClientComplainEntity;

public interface ComplainRepository extends JpaRepository<ClientComplainEntity, String> {

	List<ClientComplainEntity> findAllByCompanyName(String companyName);

}
