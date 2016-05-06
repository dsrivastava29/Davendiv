package com.davendiv.divyansh.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.davendiv.divyansh.DAO.UsersDAO;

public class ReportController extends AbstractController {
	@Autowired
	UsersDAO udao;

	@Override
	@RequestMapping(value = "/getPdf")
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Map<String, String>> alldata = udao.getUsersView();
		return new ModelAndView("Report", "alldata", alldata);
		// TODO Auto-generated method stub

	}

}
