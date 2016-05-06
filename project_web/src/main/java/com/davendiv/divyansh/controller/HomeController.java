package com.davendiv.divyansh.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.davendiv.divyansh.DAO.StartDAO;
import com.davendiv.divyansh.DAO.UsersDAO;
import com.davendiv.divyansh.exception.ResourceNotFoundException;
import com.davendiv.divyansh.jdbc.TestConnection;
import com.davendiv.divyansh.pojo.Login;
import com.davendiv.divyansh.pojo.Users;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	StartDAO start;
	@Autowired
	UsersDAO userDao;

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("defaulterror");
		model.addObject("errMsg", "this is Connection Exception");

		return model;

	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ModelAndView handleAllException(ResourceNotFoundException ex) {

		ModelAndView model = new ModelAndView("defaulterror");
		model.addObject("errMsg", "this is Exception.class");

		return model;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, @ModelAttribute("login") Login login, HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);
		// StartDAO start=new StartDAO();
		try {
			if (!TestConnection.check()) {
				start.runFirstScript();
			}
			if (session.getAttribute("name") != null)
				return "userMain";

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "home";
	}

	@RequestMapping(value = "usercreated.htm", method = RequestMethod.GET)
	public String userhome(Locale locale, @ModelAttribute("users") Users users, @ModelAttribute("login") Login login,
			HttpSession session) {
		logger.info("Welcome home! The client locale is {}.", locale);
		session.invalidate();

		return "home";
	}

}
