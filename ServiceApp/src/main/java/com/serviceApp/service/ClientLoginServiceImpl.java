package com.serviceApp.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.serviceApp.DTO.ClientLoginDTO;
import com.serviceApp.entity.RegistrationEntity;
import com.serviceApp.repository.ClientLoginRepository;
import com.serviceApp.utility.response.Response;

@Service
@PropertySource(value = { "messages.properties" })
public class ClientLoginServiceImpl implements ClientLoginService{

	@Autowired
	private ClientLoginRepository clientLoginRepository;
	
	@Autowired
	private Environment environment;
	
	@Override
	public Response login(@Valid ClientLoginDTO loginDTO) {
		RegistrationEntity registrationEntity=clientLoginRepository.findByEmail(loginDTO.getEmailId());
		System.out.println(registrationEntity.getEmail());
		System.out.println(registrationEntity.getPassword());
		
		if (registrationEntity != null) {
			if (loginDTO.getPassword().equals(registrationEntity.getPassword()) ) {
				System.out.println("sucessfully login");
				return new Response(environment.getProperty("LOGIN_SUCCESS"),
						environment.getProperty("SERVER_CODE_SUCCESS"));
			}
			return new Response(environment.getProperty("INVALID_PASSWORD"),
					environment.getProperty("SERVER_CODE_ERROR"));
		} else {
			return new Response(environment.getProperty("INVALID_CREDENTIALS"),
					environment.getProperty("SERVER_CODE_ERROR"));
		}
	}
}
