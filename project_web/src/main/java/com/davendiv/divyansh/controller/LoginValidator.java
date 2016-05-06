package com.davendiv.divyansh.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.davendiv.divyansh.pojo.Login;

@Component
public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
		return clazz.equals(Login.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uname", "error.invalid.uname", "Please check the username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.pass",
				"Please check the password");
		// TODO Auto-generated method stub

	}

}
