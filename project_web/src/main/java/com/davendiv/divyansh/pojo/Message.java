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
@Table(name = "message", catalog = "davendiv", uniqueConstraints = @UniqueConstraint(columnNames = "messegeid"))
public class Message implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private MessageId id;
	private Inbox inbox;
	private long sender;
	private String subject;
	private String msgBody;

	public Message() {
	}

	public Message(MessageId id, Inbox inbox, long sender) {
		this.id = id;
		this.inbox = inbox;
		this.sender = sender;
	}

	public Message(MessageId id, Inbox inbox, long sender, String subject, String msgBody) {
		this.id = id;
		this.inbox = inbox;
		this.sender = sender;
		this.subject = subject;
		this.msgBody = msgBody;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "messegeid", column = @Column(name = "messegeid", unique = true, nullable = false, length = 50)),
			@AttributeOverride(name = "reciever", column = @Column(name = "reciever", nullable = false)) })
	public MessageId getId() {
		return this.id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "reciever", nullable = false, insertable = false, updatable = false)
	public Inbox getInbox() {
		return this.inbox;
	}

	@Column(name = "msg_body", length = 500)
	public String getMsgBody() {
		return this.msgBody;
	}

	@Column(name = "sender", nullable = false)
	public long getSender() {
		return this.sender;
	}

	@Column(name = "subject", length = 200)
	public String getSubject() {
		return this.subject;
	}

	public void setId(MessageId id) {
		this.id = id;
	}

	public void setInbox(Inbox inbox) {
		this.inbox = inbox;
	}

	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

	public void setSender(long sender) {
		this.sender = sender;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
