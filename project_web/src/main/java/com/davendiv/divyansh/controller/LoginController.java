package com.davendiv.divyansh.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.davendiv.divyansh.DAO.UsersDAO;
import com.davendiv.divyansh.exception.LoginFailException;
import com.davendiv.divyansh.pojo.Davenfeed;
import com.davendiv.divyansh.pojo.Login;
import com.davendiv.divyansh.pojo.Role;
import com.davendiv.divyansh.pojo.Users;

@Controller
@RequestMapping("/login.htm")
public class LoginController {
	@Autowired
	UsersDAO dao;

	@Autowired
	@Qualifier("loginValidator")
	LoginValidator loginValidator;

	@RequestMapping(method = RequestMethod.POST)
	protected String doSubmitAction(@ModelAttribute("login") Login login, BindingResult result, HttpSession session,
			ModelMap model) throws LoginFailException, Exception {

		loginValidator.validate(login, result);
		if (result.hasErrors())
			return "home";
		try {
			Login logindetail = dao.get(login.getUname());

			if (logindetail.getPassword().equals(login.getPassword())) {
				Users loggedUser = dao.get(logindetail.getUserid());
				// Set<Role> roles=dao.getRoles(loggedUser.getRoles());
				Set<Role> roles = loggedUser.getRoles();
				int isadmin = 0;
				for (Role r : roles) {
					if (r.getRoleName().equals(Role.admin_role)) {
						isadmin = 1;
					}
				}
				Set<Davenfeed> feeds = dao.getFeeds(logindetail.getUserid());
				session.setAttribute("sessionid", Math.random());
				session.setAttribute("name", loggedUser.getUname());
				session.setAttribute("uid", loggedUser.getUserid());
				session.setAttribute("currentuser", loggedUser);
				session.setAttribute("roles", roles);
				session.setAttribute("isadmin", isadmin);
				String pic = loggedUser.getLogicalpic();

				if (pic != null) {

					session.setAttribute("picture", pic);
				}
				model.addAttribute("feeds", feeds);
				return "userMain";

			} else
				return "home";
		} catch (Exception e) {

			throw new LoginFailException();
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	protected String doSomeAction(@ModelAttribute("login") Login login, BindingResult result, HttpSession session,
			ModelMap model) throws LoginFailException, Exception {
		if (session.getAttribute("name") != null) {
			return "home";
		} else {
			return "userMain";
		}

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("defaulterror");
		model.addObject("errMsg", "this is LoginException");

		return model;

	}

	@ExceptionHandler(LoginFailException.class)

	public ModelAndView handleAllException(LoginFailException ex) {

		ModelAndView model = new ModelAndView("loginFailed");
		model.addObject(new Login());
		model.addObject("errMsg", "Login Failed. Please use your own credentials");

		return model;
	}

	@InitBinder("login")
	private void initLoginBinder(WebDataBinder binder) {

		binder.setValidator(loginValidator);
	}

}
