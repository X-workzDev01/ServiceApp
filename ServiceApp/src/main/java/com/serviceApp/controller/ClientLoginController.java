package com.serviceApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviceApp.dto.ClientComplainDTO;
import com.serviceApp.dto.LoginDTO;
import com.serviceApp.entity.CompanyGadgetListEntity;
import com.serviceApp.service.ClientLoginService;
import com.serviceApp.utility.response.Response;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8080" })
public class ClientLoginController {

	@Autowired
	private ClientLoginService clientLoginService;

	private Logger logger = LoggerFactory.getLogger(getClass());

	public ClientLoginController() {
		logger.info("invoking ---------" + this.getClass().getSimpleName());
	}

	@PostMapping("/clientlogin")
	public ResponseEntity<Response> login(@Valid /* @RequestBody */ LoginDTO loginDTO) {
		return new ResponseEntity<Response>(clientLoginService.login(loginDTO), HttpStatus.OK);
	}

	@PostMapping("/viewGadgets/{emailId}")
	public List<CompanyGadgetListEntity> listOfGadgets(@PathVariable ("emailId") String emailId) {
		return clientLoginService.getListOfGadgets(emailId);
	}

	@PostMapping("/createTicket")
	public ResponseEntity<Response> createTicket(@Valid ClientComplainDTO clientComplainDTO) {
		return new ResponseEntity<Response>(clientLoginService.createTicket(clientComplainDTO), HttpStatus.OK);
	}
}
