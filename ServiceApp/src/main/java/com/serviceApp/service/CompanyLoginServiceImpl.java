package com.serviceApp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.serviceApp.dto.LoginDTO;
import com.serviceApp.entity.ClientComplainEntity;
import com.serviceApp.entity.CompanyGadgetListEntity;
import com.serviceApp.entity.CompanyLoginEntity;
import com.serviceApp.repository.CompanyGadgetRepository;
import com.serviceApp.repository.ComplainRepository;
import com.serviceApp.repository.LoginRepository;
import com.serviceApp.utility.response.Response;

@Service
@PropertySource(value = { "messages.properties" })
public class CompanyLoginServiceImpl implements CompanyLoginService {

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private ComplainRepository complainRepository;
	
	@Autowired
	private CompanyGadgetRepository companyGadgetRepository;

	@Autowired
	private Environment environment;

	private Logger logger = LoggerFactory.getLogger(getClass());

	public CompanyLoginServiceImpl() {
		logger.info("invoking " + this.getClass().getSimpleName());
	}

	@Override
	public Response login(LoginDTO loginDTO) {
		logger.info("invokiing loginDTO");
		CompanyLoginEntity companyLoginEntity = loginRepository.findByEmailId(loginDTO.getEmailId());
		logger.info("serching for credantials based on email id");
		if (companyLoginEntity != null) {
			logger.info("credantials found");
			if (loginDTO.getPassword().equals(companyLoginEntity.getPassword())) {
				logger.info("email and password mathch with credantials");
				return new Response(environment.getProperty("LOGIN_SUCCESS"),
						environment.getProperty("SERVER_CODE_SUCCESS"), companyLoginEntity);
			}
			logger.info("password does't match");
			return new Response(environment.getProperty("INVALID_PASSWORD"),
					environment.getProperty("SERVER_CODE_ERROR"));
		} else {
			logger.info("email id not found in databased");
			return new Response(environment.getProperty("INVALID_CREDENTIALS"),
					environment.getProperty("SERVER_CODE_ERROR"));
		}
	}

	@Override
	public List<ClientComplainEntity> veiwAllTicketas() {
		logger.info("invoking veiwAllTicketas()");
		List<ClientComplainEntity> clientComplainEntity = complainRepository.findAll();
		logger.info("returning response");
		return clientComplainEntity;
	}
	@Override
	public List<CompanyGadgetListEntity> veiwAllGadgets() {
		logger.info("invoking veiwAllGadgets()");
		List<CompanyGadgetListEntity> gadgetListEntities = companyGadgetRepository.findAll();
		logger.info("returning response");
		return gadgetListEntities;
	}
}
