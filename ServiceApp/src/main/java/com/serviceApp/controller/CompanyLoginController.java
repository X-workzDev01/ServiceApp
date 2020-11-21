package com.serviceApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviceApp.dto.LoginDTO;
import com.serviceApp.entity.ClientComplainEntity;
import com.serviceApp.service.CompanyLoginService;
import com.serviceApp.utility.response.Response;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class CompanyLoginController {

	@Autowired
	private CompanyLoginService companyLoginService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	public CompanyLoginController() {
		logger.info("invoking ---------" + this.getClass().getSimpleName());
	}

	@PostMapping("/login")
	//@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Response> login(@Valid LoginDTO logindto) {

		return new ResponseEntity<Response>(companyLoginService.login(logindto), HttpStatus.OK);
	}
	
	@GetMapping("/viewAllTickets")
	public List<ClientComplainEntity> viewAllTickets(){
		return companyLoginService.veiwAllTicketas();
	}
}
