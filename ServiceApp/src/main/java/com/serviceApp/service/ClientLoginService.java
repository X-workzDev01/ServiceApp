package com.serviceApp.service;

import com.serviceApp.DTO.ClientLoginDTO;
import com.serviceApp.utility.response.Response;

public interface ClientLoginService {

	public Response login(ClientLoginDTO clientLoginDTO);
}
