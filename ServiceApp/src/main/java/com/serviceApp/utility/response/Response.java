package com.serviceApp.utility.response;

public class Response {

	private String statusCode; // create status integer for user response
	private String message; // create message in String for give the user message
	private Object object;
	// private Object data;
	
	public Response(String message , String statusCode) {
		this.statusCode = statusCode;
		this.message = message;
	}
	
	public Response(String message , String statusCode, Object object) {
		this.statusCode = statusCode;
		this.message = message;
		this.object = object;
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

	public Object getObject() {
		return object;
	}
	
	public void setObject(Object object) {
		this.object = object;
	}
	
}
