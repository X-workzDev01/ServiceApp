package com.serviceApp.service;

import java.util.Date;
import java.util.List;

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
import com.serviceApp.utility.passwordGenerater.AutoGenerateString;
import com.serviceApp.utility.response.Response;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private Environment environment;

	@Autowired
	private JMS javaMailSender;

	@Autowired
	private RegistrationRepository registrationRepository;

	private Logger logger = LoggerFactory.getLogger(getClass());

	public RegistrationServiceImpl() {
		logger.info("invoking " + this.getClass().getSimpleName());
	}

	@Override
	public Response clientRegistration(RegistrationDTO registrationDTO) {
		logger.info("invoking clientRegistration()");
		RegistrationEntity registrationEntity = new RegistrationEntity();
		RegistrationEntity entity = registrationRepository.findByCompanyName(registrationDTO.getCompanyName());
		logger.info("checkiing for client already there or not");
		if (entity == null) {
			logger.info("");
			BeanUtils.copyProperties(registrationDTO, registrationEntity);
			registrationEntity.setPassword(AutoGenerateString.autoGenerateString());
			registrationEntity.setDate(new Date());
			registrationEntity.setAuditStatus("insert");
			RegistrationEntity registered = registrationRepository.save(registrationEntity);
			javaMailSender.sendMail(registrationDTO.getEmailId(), registrationEntity.getPassword());
			return new Response(environment.getProperty("USER_REGISTERD"),
					environment.getProperty("SERVER_CODE_SUCCESS"), registered);
		} else {
			return new Response(environment.getProperty("CLIENT_PRESENT"),
					environment.getProperty("SERVER_CODE_ERROR"));
		}
	}

	@Override
	public List<RegistrationEntity> getAllClients() {
		List<RegistrationEntity> registrationEntity = registrationRepository.findAll();
		return registrationEntity;
	}
}
