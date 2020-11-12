package com.serviceApp.service;

import com.serviceApp.entity.CompanyLoginEntity;
import com.serviceApp.utility.response.Response;

public interface CompanyLoginService {

	public Response login(CompanyLoginEntity companyLoginEntity);
}
