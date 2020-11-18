package com.serviceApp.utility.passwordGenerater;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class AutoGeneratePassword {

	public String autoGeneratePassword() {
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz@#$%*";
		Random random = new Random();

		int len = 8;
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			sb.append(AB.charAt(random.nextInt(AB.length())));
		}
		return sb.toString();
	}

		
}
