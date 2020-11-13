package com.serviceApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.serviceApp.entity.RegistrationEntity;
import com.serviceApp.repository.RegistrationRepository;
import com.serviceApp.utility.mailSender.JMS;
import com.serviceApp.utility.response.Response;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private Environment environment;

	@Autowired
	private JMS javaMailSender;
	
	@Autowired
	private RegistrationRepository registrationRepository;

	@Override
	public Response clientRegistration(RegistrationEntity registrationEntity) {
		RegistrationEntity entity = registrationRepository.findByCompanyName(registrationEntity.getCompanyName());
		if (entity == null) {
			registrationRepository.save(registrationEntity);
			javaMailSender.sendMail(registrationEntity.getEmail());
			return new Response(environment.getProperty(""), environment.getProperty("SERVER_CODE_SUCCESS"));
		} else {
			return new Response(environment.getProperty("CLIENT_PRESENT"),
					environment.getProperty("SERVER_CODE_ERROR"));
		}
	}
}
