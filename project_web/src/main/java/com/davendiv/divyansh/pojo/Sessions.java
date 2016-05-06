package com.davendiv.divyansh.pojo;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
@Table(name = "sessions", catalog = "davendiv", uniqueConstraints = @UniqueConstraint(columnNames = "sessionid"))
public class Sessions implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private SessionsId id;
	private Date timestamp;
	private Users users;
	private String hostname;
	private String session;

	public Sessions() {
	}

	public Sessions(SessionsId id, Users users) {
		this.id = id;
		this.users = users;
	}

	public Sessions(SessionsId id, Users users, String hostname, String session) {
		this.id = id;
		this.users = users;
		this.hostname = hostname;
		this.session = session;
	}

	@Column(name = "hostname", length = 20)
	public String getHostname() {
		return this.hostname;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "sessionid", column = @Column(name = "sessionid", unique = true, nullable = false, length = 200)),
			@AttributeOverride(name = "userid", column = @Column(name = "userid", nullable = false)) })
	public SessionsId getId() {
		return this.id;
	}

	@Column(name = "session", length = 20)
	public String getSession() {
		return this.session;
	}

	@Version
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timestamp", nullable = false, length = 19)
	public Date getTimestamp() {
		return this.timestamp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid", nullable = false, insertable = false, updatable = false)
	public Users getUsers() {
		return this.users;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public void setId(SessionsId id) {
		this.id = id;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
