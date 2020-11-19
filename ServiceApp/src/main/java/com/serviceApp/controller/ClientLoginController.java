package com.serviceApp.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviceApp.dto.LoginDTO;
import com.serviceApp.service.ClientLoginService;
import com.serviceApp.utility.response.Response;

@RestController
@RequestMapping("/api")
public class ClientLoginController {
	
	@Autowired
	private ClientLoginService clientLoginService;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public ClientLoginController() {
		logger.info("invoking ---------"+this.getClass().getSimpleName());
	}

	@PostMapping("/clientlogin")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<Response> login(@Valid LoginDTO loginDTO) {
		
		return new ResponseEntity<Response>(clientLoginService.login(loginDTO), HttpStatus.OK);
	}

}
