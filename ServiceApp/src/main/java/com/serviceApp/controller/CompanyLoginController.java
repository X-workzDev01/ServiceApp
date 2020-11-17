package com.serviceApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviceApp.dto.LoginDTO;
import com.serviceApp.service.CompanyLoginService;
import com.serviceApp.utility.response.Response;

@RestController
@RequestMapping("/api")
public class CompanyLoginController {

	@Autowired
	private CompanyLoginService companyLoginService;

	@PostMapping("/login")
	public ResponseEntity<Response> login(LoginDTO logindto) {

		return new ResponseEntity<Response>(companyLoginService.login(logindto), HttpStatus.OK);
	}
}
