package com.davendiv.divyansh.pojo;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "connectionnotification", catalog = "davendiv")
@PrimaryKeyJoinColumn(name = "notid")
public class ConnectionNotification extends Notification implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Long connid;
	private String sender;

	public Long getConnid() {
		return connid;
	}

	public String getSender() {
		return sender;
	}

	public void setConnid(Long connid) {
		this.connid = connid;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

}
