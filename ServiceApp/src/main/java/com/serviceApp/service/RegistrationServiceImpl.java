package com.serviceApp.service;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.serviceApp.dto.RegistrationDTO;
import com.serviceApp.entity.RegistrationEntity;
import com.serviceApp.repository.RegistrationRepository;
import com.serviceApp.utility.mailSender.JMS;
import com.serviceApp.utility.passwordGenerater.AutoGeneratePassword;
import com.serviceApp.utility.response.Response;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private Environment environment;

	@Autowired
	private JMS javaMailSender;
<<<<<<< HEAD

	@Autowired
	private AutoGeneratePassword autoGeneratePassword;
	private String password = autoGeneratePassword.autoGeneratePassword();

=======
	
>>>>>>> clientLogin
	@Autowired
	private RegistrationRepository registrationRepository;
	
private Logger logger = LoggerFactory.getLogger(getClass());
	
	public RegistrationServiceImpl() {
		logger.info("invoking "+this.getClass().getSimpleName());
	}

	@Override
	public Response clientRegistration( @Valid  RegistrationDTO registrationDTO) {

		RegistrationEntity registrationEntity = new RegistrationEntity();
		RegistrationEntity entity = registrationRepository.findByCompanyName(registrationDTO.getCompanyName());
		if (entity == null) {
			BeanUtils.copyProperties(registrationDTO, registrationEntity);
			registrationEntity.setPassword(AutoGeneratePassword.autoGeneratePassword());
			registrationRepository.save(registrationEntity);
<<<<<<< HEAD
			javaMailSender.sendMail(registrationDTO.getEmailId(), password);
=======
			javaMailSender.sendMail(registrationDTO.getEmailId(), registrationEntity.getPassword());
>>>>>>> clientLogin
			return new Response(environment.getProperty("USER_REGISTERD"),
					environment.getProperty("SERVER_CODE_SUCCESS"));
		} else {
			return new Response(environment.getProperty("CLIENT_PRESENT"),
					environment.getProperty("SERVER_CODE_ERROR"));
		}
	}

	@Override
	public List<RegistrationEntity> getAllClients() {
		List<RegistrationEntity> registrationEntity= registrationRepository.findAll();
		return registrationEntity;
	}
}
