package com.davendiv.divyansh.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "post", catalog = "davendiv")
public class Post implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String postid;
	private String postmsg;
	private Date posttime;
	private Set<Comment> comments = new HashSet<Comment>(0);

	private Set<Group> groups = new HashSet<Group>(0);

	public Post() {
	}

	public Post(String postid, String postmsg, Date posttime) {
		this.postid = postid;
		this.postmsg = postmsg;
		this.posttime = posttime;
	}

	public Post(String postid, String postmsg, Date posttime, Set<Comment> comments, Set<Group> groups) {
		this.postid = postid;
		this.postmsg = postmsg;
		this.posttime = posttime;
		this.comments = comments;

		this.groups = groups;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
	public Set<Comment> getComments() {
		return this.comments;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "groupfeedrecord", catalog = "davendiv", joinColumns = {
			@JoinColumn(name = "postid", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "groupid", nullable = false, updatable = false) })
	public Set<Group> getGroups() {
		return this.groups;
	}

	@Id

	@Column(name = "postid", unique = true, nullable = false, length = 100)
	public String getPostid() {
		return this.postid;
	}

	@Column(name = "postmsg", nullable = false, length = 500)
	public String getPostmsg() {
		return this.postmsg;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "posttime", nullable = false, length = 19)
	public Date getPosttime() {
		return this.posttime;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public void setPostid(String postid) {
		this.postid = postid;
	}

	public void setPostmsg(String postmsg) {
		this.postmsg = postmsg;
	}

	public void setPosttime(Date posttime) {
		this.posttime = posttime;
	}

}
