package com.davendiv.divyansh.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role", catalog = "davendiv")
public class Role implements java.io.Serializable {

	/**
	 *
	 */
	public static final String admin_role = "admin";
	public static final String user_role = "user";
	private static final long serialVersionUID = 1L;

	private int roleid;
	private String roleName;
	private Set<Users> userses = new HashSet<Users>(0);

	public Role() {
	}

	public Role(int roleid, String roleName) {
		this.roleid = roleid;
		this.roleName = roleName;
	}

	public Role(int roleid, String roleName, Set<Users> userses) {
		this.roleid = roleid;
		this.roleName = roleName;
		this.userses = userses;
	}

	@Id

	@Column(name = "roleid", unique = true, nullable = false)
	public int getRoleid() {
		return this.roleid;
	}

	@Column(name = "role_name", nullable = false, length = 20)
	public String getRoleName() {
		return this.roleName;
	}

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles")
	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

}
