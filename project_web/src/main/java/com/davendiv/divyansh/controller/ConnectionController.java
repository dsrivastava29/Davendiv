package com.davendiv.divyansh.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.davendiv.divyansh.DAO.ConnectionDAO;
import com.davendiv.divyansh.DAO.NotificationDAO;
import com.davendiv.divyansh.DAO.UsersDAO;
import com.davendiv.divyansh.exception.ResourceNotFoundException;
import com.davendiv.divyansh.exception.UserException;
import com.davendiv.divyansh.pojo.Users;

@Controller
public class ConnectionController {
	@Autowired
	ConnectionDAO cdao;
	@Autowired
	UsersDAO udao;
	@Autowired
	NotificationDAO notdao;

	@RequestMapping(value = "addcontact.htm", method = RequestMethod.POST)
	public String addContact(HttpServletRequest req, HttpServletResponse resp) {
		String obj = req.getParameter("action");

		JSONObject input = new JSONObject(obj);
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sender = input.getString("myuser");
		String newcon = input.getString("link");
		// ConnectionDAO cdao=new ConnectionDAO();
		Users logged = (Users) req.getSession().getAttribute("currentuser");
		if (!sender.equals(logged.getUname())) {
			out.println("0");
			return null;
		}
		try {
			Long id = cdao.addContact(logged, newcon, "pending");
			Users next = udao.getUByName(newcon);
			notdao.notifyCon(next, sender, id);
		} catch (UserException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		out.println(logged.getConnectiondetailses().size());

		return null;

	}

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
}
