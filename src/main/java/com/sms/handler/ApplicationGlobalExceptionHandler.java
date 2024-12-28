package com.sms.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.sms.exception.StudentServiceBusinessException;

@RestControllerAdvice
public class ApplicationGlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ServiceResponse<?> handleMethodArgumentException(MethodArgumentNotValidException exception) {
		ServiceResponse<?> serviceResponse = new ServiceResponse<>();
		List<ErrorDTO> errorDTOList = new ArrayList<>();
		exception.getBindingResult().getFieldErrors()
				.forEach(error -> errorDTOList.add(new ErrorDTO(error.getDefaultMessage())));
		serviceResponse.setStatus(HttpStatus.BAD_REQUEST);
		serviceResponse.setError(errorDTOList);
		return serviceResponse;

	}

	@ExceptionHandler(StudentServiceBusinessException.class)
	public ServiceResponse<?> handleServiceException(StudentServiceBusinessException exception) {
		ServiceResponse<?> serviceResponse = new ServiceResponse<>();
		List<ErrorDTO> errorDTOList = new ArrayList<>();
		errorDTOList.add(new ErrorDTO(exception.getMessage()));
		serviceResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		serviceResponse.setError(errorDTOList);
		return serviceResponse;
	}

}
