package com.davendiv.divyansh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.davendiv.divyansh.DAO.ConnectionDAO;
import com.davendiv.divyansh.DAO.UsersDAO;
import com.davendiv.divyansh.exception.UserException;
import com.davendiv.divyansh.pojo.Connectiondetails;
import com.davendiv.divyansh.pojo.Davenfeed;
import com.davendiv.divyansh.pojo.Login;
import com.davendiv.divyansh.pojo.Notification;
import com.davendiv.divyansh.pojo.Users;

@Controller
public class PageChangeController {
	@Autowired
	ConnectionDAO cdao;
	@Autowired
	UsersDAO userdao;

	@RequestMapping(value = "connections.htm", method = RequestMethod.GET)
	public String connectionPage(HttpServletRequest req, Model model) {

		Set<Connectiondetails> cons = null;
		List<Map<String, Object>> allusers = null;
		List<Map<String, Object>> connusers = new ArrayList<Map<String, Object>>();
		try {
			cons = ((Users) req.getSession().getAttribute("currentuser")).getConnectiondetailses();
			Users temp = null;
			Map<String, Object> one = null;
			ArrayList<String> existing = new ArrayList<String>();
			for (Connectiondetails c : cons) {
				temp = userdao.getUByName(c.getConusername());
				one = new HashMap<String, Object>();
				one.put("userpic", temp.getLogicalpic());
				one.put("name", temp.getPersonalInfo().getFirstname() + " " + temp.getPersonalInfo().getLastname());
				one.put("nm", temp.getUname());
				one.put("conid", c.getConnid());

				one.put("status", c.getStatus());
				connusers.add(one);
				existing.add(temp.getUname());
			}
			allusers = cdao.getAllUsers(existing, (String) req.getSession().getAttribute("name"));
		} catch (UserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// req.getSession().setAttribute("connusers", connusers);
		// req.getSession().setAttribute("allusers", allusers);
		model.addAttribute("connusers", connusers);
		model.addAttribute("allusers", allusers);
		return "connections";
	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("defaulterror");
		model.addObject("errMsg", "this is LoginException");

		return model;

	}

	@RequestMapping(value = "job.htm", method = RequestMethod.GET)
	public String jobPage(HttpSession session) {
		return "job";

	}

	@RequestMapping(value = "lost.htm", method = RequestMethod.GET)
	public String lostReturnPage(HttpSession session, Model model) {
		if (session.getAttribute("name") != null)
			return "userMain";
		else {
			session.invalidate();
			model.addAttribute(new Login());
			return "home";
		}
	}

	@RequestMapping(value = "daven.htm", method = RequestMethod.GET)
	public String mainPage(HttpSession session) {
		return "userMain";
	}

	@RequestMapping(value = "messeges.htm", method = RequestMethod.GET)
	public String messegesPage(HttpSession session) {
		return "messeges";

	}

	@RequestMapping(value = "notification.htm", method = RequestMethod.GET)
	public String notificationPage(HttpServletRequest req, Model model) {
		List<Notification> nots = null;
		try {
			nots = userdao.fetchNotification((Users) req.getSession().getAttribute("currentuser"));
			req.getSession().setAttribute("notif", nots);
			return "notification";
		} catch (UserException devException) {
			// TODO Auto-generated catch block
			devException.printStackTrace();
		}

		return "userMain";

	}

	@RequestMapping(value = "refresh.htm", method = RequestMethod.GET)
	public String refreshPage(HttpServletRequest req, HttpServletResponse resp) {
		PrintWriter out;
		try {
			out = resp.getWriter();
			out.println("success");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@RequestMapping(value = "updateskills.htm", method = RequestMethod.GET)
	public String skillsPage(HttpSession session) {
		return "updateskills";
	}

	@RequestMapping(value = "summary.htm", method = RequestMethod.GET)
	public String summaryPage(HttpSession session) {
		return "summary";

	}

	@RequestMapping(value = "viewprofile.htm", method = RequestMethod.GET)
	public String viewProfile(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		try {
			Users viewuser = userdao.getUByName(id);
			if (viewuser != null) {
				model.addAttribute("viewuser", viewuser);
			} else {
				model.addAttribute("viewuser", null);
			}
			Set<Davenfeed> feeds = viewuser.getDavenfeeds();
			model.addAttribute("feeds", feeds);
		} catch (UserException devException) {
			// TODO Auto-generated catch block
			devException.printStackTrace();
		}

		return "viewProfile";
	}
}
