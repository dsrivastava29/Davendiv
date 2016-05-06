package com.davendiv.divyansh.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Login {

	private long userid;

	private String uname;

	private String password;

	public Login() {

	}

	public Login(String uname, String password) {

		this.uname = uname;
		this.password = password;
	}

	@Column(name = "pass", nullable = false, length = 20)
	public String getPassword() {
		return password;
	}

	@Column(name = "uname", nullable = false, length = 50)
	public String getUname() {
		return uname;
	}

	@Id
	@GeneratedValue
	@Column(name = "userid", unique = true, nullable = false)
	public long getUserid() {
		return this.userid;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

}
