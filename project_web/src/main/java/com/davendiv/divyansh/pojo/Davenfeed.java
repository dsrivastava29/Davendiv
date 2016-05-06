package com.davendiv.divyansh.pojo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "davenfeed", catalog = "davendiv", uniqueConstraints = @UniqueConstraint(columnNames = "davenid"))
public class Davenfeed implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private DavenfeedId id;
	private Users users;
	private String post;

	public Davenfeed() {
	}

	public Davenfeed(DavenfeedId id, Users users) {
		this.id = id;
		this.users = users;
	}

	public Davenfeed(DavenfeedId id, Users users, String post) {
		this.id = id;
		this.users = users;
		this.post = post;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "davenid", column = @Column(name = "davenid", unique = true, nullable = false, length = 100)),
			@AttributeOverride(name = "userid", column = @Column(name = "userid", nullable = false)) })
	public DavenfeedId getId() {
		return this.id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false, insertable = false, updatable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setId(DavenfeedId id) {
		this.id = id;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
