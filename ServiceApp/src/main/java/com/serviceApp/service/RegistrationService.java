package com.serviceApp.service;

import com.serviceApp.DTO.RegistrationDTO;
import com.serviceApp.entity.RegistrationEntity;
import com.serviceApp.utility.response.Response;

public interface RegistrationService {
	public Response clientRegistration(RegistrationDTO registrationDTO);
}
