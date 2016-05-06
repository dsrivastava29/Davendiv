package com.davendiv.divyansh.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.davendiv.divyansh.pojo.Login;
import com.davendiv.divyansh.pojo.Users;

@Controller
@RequestMapping("/logout.htm")
public class LogoutController {
	@RequestMapping(method = RequestMethod.GET)
	public String handleRequest(HttpServletRequest request, @ModelAttribute("login") Login login,
			@ModelAttribute("users") Users users, BindingResult result) {

		request.getSession().invalidate();

		return "home";
	}

}
