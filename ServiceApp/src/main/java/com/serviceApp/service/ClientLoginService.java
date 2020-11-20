package com.serviceApp.service;

import java.util.List;

import com.serviceApp.dto.ClientComplainDTO;
import com.serviceApp.dto.LoginDTO;
import com.serviceApp.entity.CompanyGadgetLIstEntity;
import com.serviceApp.utility.response.Response;

public interface ClientLoginService {

	public Response login(LoginDTO clientLoginDTO);
	
	public List<CompanyGadgetLIstEntity	> getListOfGadgets(String emaailId);
	
	public Response createTicket(ClientComplainDTO clientComplainDTO);
}
