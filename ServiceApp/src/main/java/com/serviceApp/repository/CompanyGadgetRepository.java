package com.serviceApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviceApp.entity.CompanyGadgetLIstEntity;

public interface CompanyGadgetRepository extends JpaRepository<CompanyGadgetLIstEntity, Integer>{

	List<CompanyGadgetLIstEntity> findAllByEmailId(String emailId);

}
