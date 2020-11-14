package com.serviceApp.utility.response;

public class Response {

	private String statusCode; // create status integer for user response
	private String message; // create message in String for give the user message
	// private Object data;
	
	public Response(String message , String statusCode) {
		this.statusCode = statusCode;
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
