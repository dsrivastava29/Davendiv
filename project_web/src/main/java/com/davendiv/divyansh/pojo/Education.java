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
@Table(name = "education", catalog = "davendiv")
public class Education implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private long eduid;
	private Users users;
	private Set<Project> projects = new HashSet<Project>(0);

	public Education() {
	}

	public Education(long eduid, Users users) {
		this.eduid = eduid;
		this.users = users;
	}

	public Education(long eduid, Users users, Set<Project> projects) {
		this.eduid = eduid;
		this.users = users;
		this.projects = projects;
	}

	@Id

	@Column(name = "eduid", unique = true, nullable = false)
	public long getEduid() {
		return this.eduid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "education")
	public Set<Project> getProjects() {
		return this.projects;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setEduid(long eduid) {
		this.eduid = eduid;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
