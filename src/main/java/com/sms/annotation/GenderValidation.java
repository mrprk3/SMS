package com.sms.annotation;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GenderValidation implements ConstraintValidator<StudentGenderValidation, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		List<String> list = Arrays.asList("Male", "Female");
		boolean res = list.contains(value);
		return res;
	}

}
