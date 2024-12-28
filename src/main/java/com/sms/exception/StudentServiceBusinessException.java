package com.sms.exception;

public class StudentServiceBusinessException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public StudentServiceBusinessException(String message) {
		super(message);
	}
}
