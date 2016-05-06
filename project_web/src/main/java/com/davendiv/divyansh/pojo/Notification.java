package com.davendiv.divyansh.pojo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notification", catalog = "davendiv")
@Inheritance(strategy = InheritanceType.JOINED)
public class Notification implements java.io.Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Long notid;
	private Users users;
	private String status;
	private String type;
	private String description;

	public String getDescription() {
		return description;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getNotid() {
		return notid;
	}

	public String getStatus() {
		return status;
	}

	public String getType() {
		return type;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	public Users getUsers() {
		return users;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setNotid(Long notid) {
		this.notid = notid;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
