package com.davendiv.divyansh.pojo;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class UploadedItem {
	private String filename;
	private String username;

	private CommonsMultipartFile fileData;

	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public String getFilename() {
		return filename;
	}

	public String getUsername() {
		return username;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
