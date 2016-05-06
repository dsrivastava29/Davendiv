package com.davendiv.divyansh.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import com.davendiv.divyansh.pojo.ConnectionNotification;
import com.davendiv.divyansh.pojo.Notification;
import com.davendiv.divyansh.pojo.Users;

@Controller
public class NotificationController {

	@Autowired
	UsersDAO udao;
	@Autowired
	NotificationDAO notdao;
	@Autowired
	ConnectionDAO cdao;

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

	@RequestMapping(value = "removenot.htm", method = RequestMethod.POST)
	public String removeNot(HttpServletRequest req, HttpServletResponse resp) {
		String obj = req.getParameter("action");

		JSONObject input = new JSONObject(obj);

		String sen = input.getString("myuser");
		String x = input.getString("notid");
		Long.parseLong(x);
		// ConnectionDAO cdao=new ConnectionDAO();
		Users logged = (Users) req.getSession().getAttribute("currentuser");

		PrintWriter out = null;
		try {
			out = resp.getWriter();
			if (!sen.equals(logged.getUname())) {
				out.println("0");
				return null;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Notification not = null;
		try {
			for (Notification n : logged.getNotification()) {
				String id = String.valueOf(n.getNotid());
				if (id.equals(x)) {
					not = n;
					break;
				}
			}
			if (udao.deleteNotification(logged, not)) {

				out.println(logged.getConnectiondetailses().size());

			}
		} catch (Exception e) {
		}

		return null;

	}

	@RequestMapping(value = "/getUname", method = RequestMethod.GET)
	public ResponseEntity<String> getPhoto(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, UserException {

		ServletContext cntx = req.getSession().getServletContext();

		Long val = Long.parseLong(req.getParameter("id"));

		Users u = udao.get(val);

		return new ResponseEntity<String>(u.getUname(), HttpStatus.CREATED);

	}

	// postfeed.htm
	@RequestMapping(value = "postfeed.htm", method = RequestMethod.POST)
	public String addFeed(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String obj = req.getParameter("action");

		JSONObject input = new JSONObject(obj);

		String sen = input.getString("text");

		// ConnectionDAO cdao=new ConnectionDAO();
		Users logged = (Users) req.getSession().getAttribute("currentuser");

		PrintWriter out = null;
		try {
			out = resp.getWriter();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		udao.addFeed(logged.getUname(), sen);
		out.println(sen);

		return null;

	}

	@RequestMapping(value = "replynot.htm", method = RequestMethod.POST)
	public String replyNotification(HttpServletRequest req, HttpServletResponse resp) {
		String obj = req.getParameter("action");

		JSONObject input = new JSONObject(obj);

		String sen = input.getString("myuser");
		String x = input.getString("notid");
		Long nid = Long.parseLong(x);
		// ConnectionDAO cdao=new ConnectionDAO();
		Users logged = (Users) req.getSession().getAttribute("currentuser");

		PrintWriter out = null;
		try {
			out = resp.getWriter();
			if (!sen.equals(logged.getUname())) {
				out.println("0");
				return null;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Notification not = null;
		try {
			for (Notification n : logged.getNotification()) {
				if (n.getNotid() == nid) {
					not = n;
					break;
				}
			}
			if (not instanceof ConnectionNotification) {
				ConnectionNotification cn = (ConnectionNotification) not;
				String person = cn.getSender();

				if (cdao.confirmCon(logged, person)) {
					notdao.updateNot(not, "confirm", logged);
					cdao.addContact(logged, person, "confirm");
				}
			}
			// logged = cdao.addContact(logged, newcon);
			// Users next = udao.getUByName(newcon);

		} catch (UserException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		out.println(logged.getConnectiondetailses().size());

		return null;

	}
}
