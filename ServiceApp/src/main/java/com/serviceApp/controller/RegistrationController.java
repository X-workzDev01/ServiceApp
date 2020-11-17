package com.serviceApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviceApp.dto.RegistrationDTO;
import com.serviceApp.entity.RegistrationEntity;
import com.serviceApp.service.RegistrationService;
import com.serviceApp.utility.response.Response;

@RestController
@RequestMapping("/api")
public class RegistrationController {

	@Autowired
	private RegistrationService registrationService;

	@PostMapping("/registration")
	public ResponseEntity<Response> clientRegistration(RegistrationDTO registrationDTO) {
		return new ResponseEntity<Response>(registrationService.clientRegistration(registrationDTO), HttpStatus.OK);
	}

	@GetMapping("/registeredClient")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<RegistrationEntity> getAllRegisteredClient(){
		return registrationService.getAllClients();
	}
}
