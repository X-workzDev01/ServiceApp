package com.serviceApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviceApp.entity.CompanyLoginEntity;
import com.serviceApp.service.CompanyLoginService;
import com.serviceApp.utility.response.Response;

@RestController
@RequestMapping("/api")
public class CompanyLoginController {

	@Autowired
	private CompanyLoginService companyLoginService;

	@GetMapping("/login")
	public ResponseEntity<Response> login(CompanyLoginEntity entity) {

		return new ResponseEntity<Response>(companyLoginService.login(entity), HttpStatus.OK);
	}
}
