package com.serviceApp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviceApp.dto.LoginDTO;
import com.serviceApp.service.ClientLoginService;
import com.serviceApp.utility.response.Response;

@RestController
@RequestMapping("/api")
public class ClientLoginController {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ClientLoginService clientLoginService;

	@PostMapping("/clientlogin")

	public ResponseEntity<Response> login(LoginDTO loginDTO) {
		
		return new ResponseEntity<Response>(clientLoginService.login(loginDTO), HttpStatus.OK);
	}

}
