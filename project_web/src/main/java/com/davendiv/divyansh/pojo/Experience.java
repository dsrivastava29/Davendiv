package com.davendiv.divyansh.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "experience", catalog = "davendiv")
public class Experience implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private long expid;
	private Users users;
	private Set<Project> projects = new HashSet<Project>(0);

	public Experience() {
	}

	public Experience(long expid, Users users) {
		this.expid = expid;
		this.users = users;
	}

	public Experience(long expid, Users users, Set<Project> projects) {
		this.expid = expid;
		this.users = users;
		this.projects = projects;
	}

	@Id

	@Column(name = "expid", unique = true, nullable = false)
	public long getExpid() {
		return this.expid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "experience")
	public Set<Project> getProjects() {
		return this.projects;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setExpid(long expid) {
		this.expid = expid;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
