package com.davendiv.divyansh.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DavenfeedId implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String davenid;
	private long userid;

	public DavenfeedId() {
	}

	public DavenfeedId(String davenid, long userid) {
		this.davenid = davenid;
		this.userid = userid;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof DavenfeedId))
			return false;
		DavenfeedId castOther = (DavenfeedId) other;

		return ((this.getDavenid() == castOther.getDavenid()) || (this.getDavenid() != null
				&& castOther.getDavenid() != null && this.getDavenid().equals(castOther.getDavenid())))
				&& (this.getUserid() == castOther.getUserid());
	}

	@Column(name = "davenid", unique = true, nullable = false, length = 100)
	public String getDavenid() {
		return this.davenid;
	}

	@Column(name = "userid", nullable = false)
	public long getUserid() {
		return this.userid;
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getDavenid() == null ? 0 : this.getDavenid().hashCode());
		result = 37 * result + (int) this.getUserid();
		return result;
	}

	public void setDavenid(String davenid) {
		this.davenid = davenid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

}
