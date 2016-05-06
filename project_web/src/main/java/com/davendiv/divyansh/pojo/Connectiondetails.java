package com.davendiv.divyansh.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "connectiondetails", catalog = "davendiv")
public class Connectiondetails implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	// private ConnectiondetailsId id;
	private Long connid;
	private Users users;
	private String status;
	private String conusername;

	public Connectiondetails() {
	}

	public Connectiondetails(Users users) {
		// this.id = id;

		this.users = users;
	}

	public Connectiondetails(Users users, String status) {
		// this.id = id;

		this.users = users;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getConnid() {
		return connid;
	}

	public String getConusername() {
		return conusername;
	}

	@Column(name = "status", length = 20)
	public String getStatus() {
		return this.status;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setConnid(Long connid) {
		this.connid = connid;
	}

	public void setConusername(String conusername) {
		this.conusername = conusername;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
