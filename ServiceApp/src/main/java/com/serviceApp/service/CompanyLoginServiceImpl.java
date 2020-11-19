package com.serviceApp.service;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.serviceApp.dto.LoginDTO;
import com.serviceApp.entity.CompanyLoginEntity;
import com.serviceApp.repository.LoginRepository;
import com.serviceApp.utility.response.Response;

@Service
@PropertySource(value = { "messages.properties" })
public class CompanyLoginServiceImpl implements CompanyLoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private Environment environment;
	
private Logger logger = LoggerFactory.getLogger(getClass());
	
	public CompanyLoginServiceImpl() {
		logger.info("invoking "+this.getClass().getSimpleName());
	}

	@Override
	public Response login(@Valid LoginDTO loginDTO) {
		CompanyLoginEntity companyLoginEntity = loginRepository.findByEmailId(loginDTO.getEmailId());
		if (companyLoginEntity != null) {
			if (loginDTO.getPassword().equals(companyLoginEntity.getPassword()) ) {

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
