package com.davendiv.divyansh.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.BindException;
import java.util.Calendar;
import java.util.Iterator;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.davendiv.divyansh.DAO.UsersDAO;
import com.davendiv.divyansh.pojo.UploadedItem;

@Controller
@RequestMapping(value = "/uploadDivPicture")
public class UploadPictureController {
	@Autowired
	UsersDAO userDao;

	ServletConfig config;
	private String uploadPath;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String create(MultipartHttpServletRequest request, HttpServletResponse response, Object command,
			BindException errors, HttpSession session) {
		try {
			Iterator<String> itr = request.getFileNames();

			MultipartFile filea = request.getFile(itr.next());
			// MultipartFile filea = request.getFile("fileData");
			Long uid = (Long) session.getAttribute("uid");
			String id = String.valueOf(uid);
			InputStream inputStream = null;
			OutputStream outputStream = null;
			String today = String.valueOf(Calendar.getInstance().getTimeInMillis());
			if (filea.getSize() > 0) {
				inputStream = filea.getInputStream();

				String rootPath = request.getSession().getServletContext().getRealPath("");
				File dir = new File(rootPath + File.separator + "webapp" + File.separator + "resources" + File.separator
						+ "div-picture");
				if (!dir.exists()) {
					dir.mkdirs();
				}

				String fname = id + today + filea.getOriginalFilename();
				File serverFile = new File(dir.getAbsolutePath() + File.separator + fname);

				if (!serverFile.exists()) {
					serverFile.createNewFile();
				}

				outputStream = new FileOutputStream(serverFile);
				System.out.println("====22=========");
				// System.out.println(filea.getOriginalFilename());
				System.out.println("=============");
				int readBytes = 0;
				byte[] buffer = new byte[8192];
				while ((readBytes = inputStream.read(buffer, 0, 8192)) != -1) {
					System.out.println("===ddd=======");
					outputStream.write(buffer, 0, readBytes);
				}
				outputStream.close();
				inputStream.close();
				// session.setAttribute("uploadFile", s );
				String saveFile = serverFile.getCanonicalPath();
				JSONObject obj = new JSONObject();
				if (storeFileLocation(uid, saveFile, dir + File.separator + fname)) {
					obj.put("response", "success");
				} else {
					obj.put("response", "fail");
				}
				PrintWriter out = response.getWriter();

				out.println(obj);

				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/home";
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getUploadForm(@ModelAttribute("uploadItem") UploadedItem uploadItem, ModelMap model,
			HttpSession session) {
		session.getAttribute("uname");

		return "success";
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	private boolean storeFileLocation(Long uid, String saveFile, String logicalPath) {
		// TODO Auto-generated method stub
		try {

			if (userDao.updatePicture(uid, saveFile, logicalPath) > 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}

	}
}
