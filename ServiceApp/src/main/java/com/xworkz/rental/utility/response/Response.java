package com.xworkz.rental.utility.response;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {

	private String statusCode; // create status integer for user response
	private String message; // create message in String for give the user message
	private Object object;
	private HttpStatus status;
	// private Object data;

	public Response(String message, String statusCode) {
		this.statusCode = statusCode;
		this.message = message;
	}
	public Response(String message, HttpStatus status) {
		this.status = status;
		this.message = message;
	}

	public Response(String message, String statusCode, Object object) {
		this.statusCode = statusCode;
		this.message = message;
		this.object = object;
	}
}
