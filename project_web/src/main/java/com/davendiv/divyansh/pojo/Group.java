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
@Table(name = "group", catalog = "davendiv")
public class Group implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private long groupid;
	private String name;
	private String owner;
	private String description;
	private Set<Post> posts = new HashSet<Post>(0);
	private Set<Users> userses = new HashSet<Users>(0);

	public Group() {
	}

	public Group(long groupid, String name, String owner) {
		this.groupid = groupid;
		this.name = name;
		this.owner = owner;
	}

	public Group(long groupid, String name, String owner, String description, Set<Post> posts, Set<Users> userses) {
		this.groupid = groupid;
		this.name = name;
		this.owner = owner;
		this.description = description;
		this.posts = posts;
		this.userses = userses;
	}

	@Column(name = "description", length = 20)
	public String getDescription() {
		return this.description;
	}

	@Id

	@Column(name = "groupid", unique = true, nullable = false)
	public long getGroupid() {
		return this.groupid;
	}

	@Column(name = "name", nullable = false, length = 20)
	public String getName() {
		return this.name;
	}

	@Column(name = "owner", nullable = false, length = 20)
	public String getOwner() {
		return this.owner;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
	public Set<Post> getPosts() {
		return this.posts;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "groups")
	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setGroupid(long groupid) {
		this.groupid = groupid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

}
