package com.davendiv.divyansh.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SessionsId implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String sessionid;
	private long userid;

	public SessionsId() {
	}

	public SessionsId(String sessionid, long userid) {
		this.sessionid = sessionid;
		this.userid = userid;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SessionsId))
			return false;
		SessionsId castOther = (SessionsId) other;

		return ((this.getSessionid() == castOther.getSessionid()) || (this.getSessionid() != null
				&& castOther.getSessionid() != null && this.getSessionid().equals(castOther.getSessionid())))
				&& (this.getUserid() == castOther.getUserid());
	}

	@Column(name = "sessionid", unique = true, nullable = false, length = 200)
	public String getSessionid() {
		return this.sessionid;
	}

	@Column(name = "userid", nullable = false)
	public long getUserid() {
		return this.userid;
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getSessionid() == null ? 0 : this.getSessionid().hashCode());
		result = 37 * result + (int) this.getUserid();
		return result;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

}
