package com.serviceApp.service;

import java.util.List;

import com.serviceApp.dto.LoginDTO;
import com.serviceApp.entity.ClientComplainEntity;
import com.serviceApp.entity.CompanyGadgetListEntity;
import com.serviceApp.utility.response.Response;

public interface CompanyLoginService {

	public Response login(LoginDTO loginDTO);
	
	public List<ClientComplainEntity> veiwAllTicketas();

	public List<CompanyGadgetListEntity> veiwAllGadgets();
}
