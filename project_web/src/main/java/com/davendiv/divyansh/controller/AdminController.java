package com.davendiv.divyansh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.davendiv.divyansh.DAO.AdminDAO;
import com.davendiv.divyansh.DAO.UsersDAO;
import com.davendiv.divyansh.pojo.Users;

@Controller
public class AdminController {
	@Autowired
	UsersDAO udao;

	@Autowired
	AdminDAO dao;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/activate.htm", method = RequestMethod.POST)
	protected String activate(HttpServletRequest req) throws Exception {
		String[] vals = getSorted(req);
		if (vals == null)
			return "home";
		dao.updateStatus(vals[1], 1);

		List<Users> all = (List<Users>) req.getSession().getAttribute("allusers");
		for (Users i : all) {
			if (i.getUname().equals(vals[1])) {
				i.setIsActive(1);
				break;
			}
		}

		req.getSession().setAttribute("allusers", all);
		return "adminBoard";

	}

	@RequestMapping(value = "/admin.htm", method = RequestMethod.GET)
	protected String adminAction(HttpServletRequest req, HttpSession session) throws Exception {
		String v = String.valueOf(session.getAttribute("isadmin"));
		int val = Integer.parseInt(v);

		if (val != 1)
			return "home";
		List<Users> all = dao.getAllUsers();
		session.setAttribute("allusers", all);
		return "adminBoard";

	}

	@RequestMapping(value = "/deactivate.htm", method = RequestMethod.POST)
	protected String deactivate(HttpServletRequest req) throws Exception {
		String[] vals = getSorted(req);
		if (vals == null)
			return "home";
		if (dao.updateStatus(vals[1], 0)) {
			@SuppressWarnings("unchecked")
			List<Users> all = (List<Users>) req.getSession().getAttribute("allusers");
			for (Users i : all) {
				if (i.getUname().equals(vals[1])) {
					i.setIsActive(1);
					break;
				}
			}
		}

		return "adminBoard";

	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteuser.htm", method = RequestMethod.GET)
	protected String deleteAction(HttpServletRequest req) throws Exception {
		String v = String.valueOf(req.getSession().getAttribute("isadmin"));
		int val = Integer.parseInt(v);
		if (val != 1)
			return "home";
		String nm = req.getParameter("id");
		dao.deleteUser(nm);
		List<Users> all = (List<Users>) req.getSession().getAttribute("allusers");
		for (Users i : all) {
			if (i.getUname().equals(nm)) {
				all.remove(i);
				break;
			}

		}
		req.getSession().setAttribute("allusers", all);
		return "adminBoard";

	}

	private String[] getSorted(HttpServletRequest req) {
		String v = String.valueOf(req.getSession().getAttribute("isadmin"));
		int val = Integer.parseInt(v);
		if (val != 1)
			return null;
		String obj = req.getParameter("action");
		JSONObject input = new JSONObject(obj);
		String[] ret = new String[2];

		ret[0] = input.getString("myuser");
		ret[1] = input.getString("uid");

		return ret;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("defaulterror");
		model.addObject("errMsg", "this is Admin Level Exception");

		return model;

	}

}
