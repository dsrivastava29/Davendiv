package com.davendiv.divyansh.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.davendiv.divyansh.DAO.UsersDAO;
import com.davendiv.divyansh.exception.UserException;
import com.davendiv.divyansh.pojo.Users;

@Controller

public class NewUserController {
	@Autowired
	UsersDAO userDao;

	@Autowired
	@Qualifier("userValidator")
	UserValidator userValidator;

	@RequestMapping(value = "create.htm", method = RequestMethod.GET)
	public String doSubmit(@ModelAttribute("users") Users users, BindingResult result, HttpSession session,
			HttpServletRequest req) throws Exception {

		return "addUserForm";

	}

	@RequestMapping(value = "newuser.htm", method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("users") Users users, BindingResult result, HttpSession session,
			ModelMap map) throws Exception {
		userValidator.validate(users, result);
		if (result.hasErrors())
			return "addUserForm";
		if (userDao.checkUser(users.getUname())) {
			result.reject("DUPLICATE", "Name is already in use");
			result.rejectValue("uname", "DUPLICATE", "Name is already registered");
			ObjectError e = new ObjectError("users", "Name is already registered");
			result.addError(e);
			return "addUserForm";
		}

		// users.setPersonalInfo(new PersonalInfo(users.getUserid()));
		String rootPath = System.getProperty("user.dir");
		File dir = new File(
				rootPath + File.separator + "webapp" + File.separator + "resources" + File.separator + "img");

		String fname = "find_user.png";
		File serverFile = new File(dir.getAbsolutePath() + File.separator + fname);
		users.setPicture(serverFile.getCanonicalPath());
		users = userDao.create(users);
		// users=userDao.create(users.getUname(),
		// users.getPass(),users.getMail(), users.getConnections());
		users.setUname(users.getUname());
		session.setAttribute("hi", "hola");
		session.setAttribute("name", users.getUname());
		session.setAttribute("uid", users.getUserid());

		users.setPersonalInfo(userDao.create(users.getPersonalInfo()));

		return "success";

	}

	@ExceptionHandler(UserException.class)
	public ModelAndView handleAllException(UserException ex) {

		ModelAndView model = new ModelAndView("defaulterror");
		model.addObject("errMsg", ex.getMessage());

		return model;
	}

	@InitBinder("users")
	private void initUserBinder(WebDataBinder binder) {
		binder.setValidator(userValidator);
	}

}
