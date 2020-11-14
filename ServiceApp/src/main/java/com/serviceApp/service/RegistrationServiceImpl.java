package com.serviceApp.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.serviceApp.DTO.RegistrationDTO;
import com.serviceApp.entity.RegistrationEntity;
import com.serviceApp.repository.RegistrationRepository;
import com.serviceApp.utility.passwordGenerater.AutoGeneratePassword;
import com.serviceApp.utility.mailSender.JMS;
import com.serviceApp.utility.response.Response;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private Environment environment;

	@Autowired
	private JMS javaMailSender;

	@Autowired
	private AutoGeneratePassword autoGeneratePassword;
	private final String password = autoGeneratePassword.autoGeneratePassword();

	@Autowired
	private RegistrationRepository registrationRepository;

	@Override
	public Response clientRegistration(@Valid RegistrationDTO registrationDTO) {

		RegistrationEntity registrationEntity = new RegistrationEntity();
		RegistrationEntity entity = registrationRepository.findByCompanyName(registrationDTO.getCompanyName());
		if (entity == null) {
			BeanUtils.copyProperties(registrationDTO, registrationEntity);
			registrationEntity.setPassword(password);
			registrationRepository.save(registrationEntity);
			javaMailSender.sendMail(registrationEntity.getEmail(), password);
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
