package com.serviceApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviceApp.entity.ClientComplainEntity;

public interface ComplainRepository extends JpaRepository<ClientComplainEntity, String> {

}
