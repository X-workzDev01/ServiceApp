package com.serviceApp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.serviceApp.dto.LoginDTO;
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
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public ClientLoginServiceImpl() {
		logger.info("invoking "+this.getClass().getSimpleName());
	}
	
	@Override
	public Response login( LoginDTO loginDTO) {
		RegistrationEntity registrationEntity=clientLoginRepository.findByEmailId(loginDTO.getEmailId());
		
		if (registrationEntity != null) {
			if (loginDTO.getPassword().equals(registrationEntity.getPassword()) ) {
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
