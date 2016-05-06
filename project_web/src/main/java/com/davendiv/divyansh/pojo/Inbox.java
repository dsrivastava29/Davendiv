package com.davendiv.divyansh.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "inbox", catalog = "davendiv")
public class Inbox implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private long userid;
	private Users users;
	private Set<Message> messages = new HashSet<Message>(0);

	public Inbox() {
	}

	public Inbox(Users users) {
		this.users = users;
	}

	public Inbox(Users users, Set<Message> messages) {
		this.users = users;
		this.messages = messages;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "inbox")
	public Set<Message> getMessages() {
		return this.messages;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "users"))
	@Id
	@GeneratedValue(generator = "generator")

	@Column(name = "userid", unique = true, nullable = false)
	public long getUserid() {
		return this.userid;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Users getUsers() {
		return this.users;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
