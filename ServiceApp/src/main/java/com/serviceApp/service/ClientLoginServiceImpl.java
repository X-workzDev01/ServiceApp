package com.serviceApp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.serviceApp.dto.ClientComplainDTO;
import com.serviceApp.dto.LoginDTO;
import com.serviceApp.entity.ClientComplainEntity;
import com.serviceApp.entity.CompanyGadgetListEntity;
import com.serviceApp.entity.RegistrationEntity;
import com.serviceApp.repository.CompanyGadgetRepository;
import com.serviceApp.repository.ComplainRepository;
import com.serviceApp.repository.RegistrationRepository;
import com.serviceApp.utility.passwordGenerater.AutoGenerateString;
import com.serviceApp.utility.response.Response;

@Service
@PropertySource(value = { "messages.properties" })
public class ClientLoginServiceImpl implements ClientLoginService {

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private CompanyGadgetRepository companyGadgetRepository;

	@Autowired
	private ComplainRepository complainRepository;

	@Autowired
	private Environment environment;

	private Logger logger = LoggerFactory.getLogger(getClass());

	public ClientLoginServiceImpl() {
		logger.info("invoking " + this.getClass().getSimpleName());
	}

	@Override
	public Response login(LoginDTO loginDTO) {
		RegistrationEntity registrationEntity = registrationRepository.findByEmailId(loginDTO.getEmailId());

		if (registrationEntity != null) {
			if (loginDTO.getPassword().equals(registrationEntity.getPassword())) {
				return new Response(environment.getProperty("LOGIN_SUCCESS"),
						environment.getProperty("SERVER_CODE_SUCCESS"),registrationEntity);
			}
			return new Response(environment.getProperty("INVALID_PASSWORD"),
					environment.getProperty("SERVER_CODE_ERROR"));
		} else {
			return new Response(environment.getProperty("INVALID_CREDENTIALS"),
					environment.getProperty("SERVER_CODE_ERROR"));
		}
	}

	@Override
	public List<CompanyGadgetListEntity> getListOfGadgets(String companyName) {

		return companyGadgetRepository.findAllByCompanyName(companyName);
	}

	@Override
	public Response createTicket(ClientComplainDTO clientComplainDTO) {
		ClientComplainEntity clientComplainEntity = new ClientComplainEntity();
		BeanUtils.copyProperties(clientComplainDTO, clientComplainEntity);
		clientComplainEntity.setTicket(AutoGenerateString.autoGenerateString());
		ClientComplainEntity created = complainRepository.save(clientComplainEntity);
		if (created != null) {
			return new Response(environment.getProperty("TICKET_CREATED"),
					environment.getProperty("SERVER_CODE_SUCCESS"),created);
		}else {
			return new Response(environment.getProperty("FAIL_TO_CREATE_TICKET"),
					environment.getProperty("SERVER_CODE_ERROR"));
		}
	}
}