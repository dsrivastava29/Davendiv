package com.davendiv.divyansh.controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.davendiv.divyansh.pojo.Users;

@Component
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class clazz) {
		// TODO Auto-generated method stub
		return clazz.equals(Users.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "uname", "error.invalid.uname", "Please check the username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", "error.invalid.pass", "Please check the password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "error.invalid.uname", "Please check the email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personalInfo.firstname", "error.invalid.first",
				"Please check the firstname");
		
				
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personalInfo.lastname", "error.invalid.lastname",
				"Please check the lastname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personalInfo.country", "error.invalid.personalInfo.country",
				"Please check the country");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personalInfo.state", "error.invalid.personalInfo.state",
				"Please check the state");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "personalInfo.city", "error.invalid.personalInfo.city",
				"Please check the city");
		// TODO Auto-generated method stub

	}

}
