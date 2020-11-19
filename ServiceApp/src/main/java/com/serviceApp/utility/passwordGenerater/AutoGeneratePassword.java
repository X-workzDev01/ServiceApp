package com.serviceApp.utility.passwordGenerater;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class AutoGeneratePassword {
	
	 public static String autoGeneratePassword() {
		 return RandomStringUtils.randomAlphanumeric(8);
	 }
}
