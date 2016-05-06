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
@Table(name = "comment", catalog = "davendiv", uniqueConstraints = @UniqueConstraint(columnNames = "commentid"))
public class Comment implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private CommentId id;
	private Post post;
	private String text;
	private long sendby;

	public Comment() {
	}

	public Comment(CommentId id, Post post, String text, long sendby) {
		this.id = id;
		this.post = post;
		this.text = text;
		this.sendby = sendby;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "postid", column = @Column(name = "postid", nullable = false, length = 100)),
			@AttributeOverride(name = "commentid", column = @Column(name = "commentid", unique = true, nullable = false, length = 100)) })
	public CommentId getId() {
		return this.id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "postid", nullable = false, insertable = false, updatable = false)
	public Post getPost() {
		return this.post;
	}

	@Column(name = "sendby", nullable = false)
	public long getSendby() {
		return this.sendby;
	}

	@Column(name = "text", nullable = false, length = 300)
	public String getText() {
		return this.text;
	}

	public void setId(CommentId id) {
		this.id = id;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public void setSendby(long sendby) {
		this.sendby = sendby;
	}

	public void setText(String text) {
		this.text = text;
	}

}
