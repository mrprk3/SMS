package com.sms.handler;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ServiceResponse<T> {

	private HttpStatus status;

	private T response;
	
	private List<ErrorDTO> error;

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}

	public List<ErrorDTO> getError() {
		return error;
	}

	public void setError(List<ErrorDTO> error) {
		this.error = error;
	}

	public ServiceResponse(HttpStatus status, T response, List<ErrorDTO> error) {
		super();
		this.status = status;
		this.response = response;
		this.error = error;
	}

	public ServiceResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
