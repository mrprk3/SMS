package com.sms.handler;

public class ErrorDTO {
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ErrorDTO(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public ErrorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
