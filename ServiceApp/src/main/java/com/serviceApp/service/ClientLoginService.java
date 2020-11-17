package com.serviceApp.service;

import com.serviceApp.dto.LoginDTO;
import com.serviceApp.utility.response.Response;

public interface ClientLoginService {

	public Response login(LoginDTO clientLoginDTO);
}
