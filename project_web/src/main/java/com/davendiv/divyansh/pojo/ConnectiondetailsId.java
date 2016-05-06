package com.davendiv.divyansh.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ConnectiondetailsId implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private long userid;
	private long connectionid;

	public ConnectiondetailsId() {
	}

	public ConnectiondetailsId(long userid, long connectionid) {
		this.userid = userid;
		this.connectionid = connectionid;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ConnectiondetailsId))
			return false;
		ConnectiondetailsId castOther = (ConnectiondetailsId) other;

		return (this.getUserid() == castOther.getUserid()) && (this.getConnectionid() == castOther.getConnectionid());
	}

	@Column(name = "connectionid", nullable = false)
	public long getConnectionid() {
		return this.connectionid;
	}

	@Column(name = "userid", nullable = false)
	public long getUserid() {
		return this.userid;
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getUserid();
		result = 37 * result + (int) this.getConnectionid();
		return result;
	}

	public void setConnectionid(long connectionid) {
		this.connectionid = connectionid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

}
