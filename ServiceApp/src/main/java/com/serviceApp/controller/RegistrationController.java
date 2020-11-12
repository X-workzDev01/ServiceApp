package com.serviceApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviceApp.entity.RegistrationEntity;
import com.serviceApp.service.RegistrationService;
import com.serviceApp.utility.response.Response;

@RestController
@RequestMapping("/api")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@PostMapping("/registration")
	public ResponseEntity<Response> clientRegistration(RegistrationEntity registrationEntity) {
		return new ResponseEntity<Response>(registrationService.clientRegistration(registrationEntity), HttpStatus.OK);

	}

}
