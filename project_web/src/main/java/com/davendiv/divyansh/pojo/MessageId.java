package com.davendiv.divyansh.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MessageId implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String messegeid;
	private long reciever;

	public MessageId() {
	}

	public MessageId(String messegeid, long reciever) {
		this.messegeid = messegeid;
		this.reciever = reciever;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MessageId))
			return false;
		MessageId castOther = (MessageId) other;

		return ((this.getMessegeid() == castOther.getMessegeid()) || (this.getMessegeid() != null
				&& castOther.getMessegeid() != null && this.getMessegeid().equals(castOther.getMessegeid())))
				&& (this.getReciever() == castOther.getReciever());
	}

	@Column(name = "messegeid", unique = true, nullable = false, length = 50)
	public String getMessegeid() {
		return this.messegeid;
	}

	@Column(name = "reciever", nullable = false)
	public long getReciever() {
		return this.reciever;
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getMessegeid() == null ? 0 : this.getMessegeid().hashCode());
		result = 37 * result + (int) this.getReciever();
		return result;
	}

	public void setMessegeid(String messegeid) {
		this.messegeid = messegeid;
	}

	public void setReciever(long reciever) {
		this.reciever = reciever;
	}

}
