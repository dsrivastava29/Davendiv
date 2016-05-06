package com.davendiv.divyansh.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.davendiv.divyansh.exception.ResourceNotFoundException;

@Controller
@RequestMapping(value = "/Dimage")
public class DivImageController {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<byte[]> getPhoto(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		ServletContext cntx = req.getSession().getServletContext();

		String val = req.getParameter("val");

		// retrieve mimeType dynamically
		String mime = cntx.getMimeType(val);
		if (mime == null) {
			resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			return null;
		}

		resp.setContentType(mime);
		File file = new File(val);
		resp.setContentLength((int) file.length());

		InputStream in = new FileInputStream(file);
		// FileUtils.openInputStream(initialFile) would also work here . Use if
		// req.
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);

		return new ResponseEntity<byte[]>(IOUtils.toByteArray(in), headers, HttpStatus.CREATED);

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("defaulterror");
		model.addObject("errMsg", "this is Image Exception");

		return model;

	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ModelAndView handleAllException(ResourceNotFoundException ex) {

		ModelAndView model = new ModelAndView("defaulterror");
		model.addObject("errMsg", "this is Exception.class");

		return model;
	}
}
