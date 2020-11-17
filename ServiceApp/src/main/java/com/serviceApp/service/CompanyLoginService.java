package com.serviceApp.service;

import com.serviceApp.dto.LoginDTO;
import com.serviceApp.utility.response.Response;

public interface CompanyLoginService {

	public Response login(LoginDTO loginDTO);
}
