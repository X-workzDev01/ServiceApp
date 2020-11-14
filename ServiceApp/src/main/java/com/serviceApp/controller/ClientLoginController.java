package com.serviceApp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviceApp.DTO.ClientLoginDTO;
import com.serviceApp.repository.ClientLoginRepository;
import com.serviceApp.service.ClientLoginService;
import com.serviceApp.utility.response.Response;

@RestController
@RequestMapping("/api")
public class ClientLoginController {
	
	Logger logger = LoggerFactory.getLogger(ClientLoginController.class);
	
	@Autowired
	private ClientLoginService clientLoginService;

	@PostMapping("/clientlogin")
	public ResponseEntity<Response> login(ClientLoginDTO clientLoginDTO) {
		
		return new ResponseEntity<Response>(clientLoginService.login(clientLoginDTO), HttpStatus.OK);
	}

}
