package com.serviceApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.serviceApp.entity.RegistrationEntity;
import com.serviceApp.repository.RegistrationRepository;
import com.serviceApp.utility.response.Response;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	private Environment environment;

	@Autowired
	private RegistrationRepository registrationRepository;

	@Override
	public Response clientRegistration(RegistrationEntity registrationEntity) {
		RegistrationEntity entity = registrationRepository.findByCompanyName(registrationEntity.getCompanyName());
		if (entity==null) {
			registrationRepository.save(registrationEntity);
		} else {
			return new Response(
					environment.getProperty("INVALID_CREDENTIALS"),
		environment.getProperty("SERVER_CODE_ERROR"));
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return null;
	}

}
