package com.davendiv.divyansh.pojo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CommentId implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String postid;
	private String commentid;

	public CommentId() {
	}

	public CommentId(String postid, String commentid) {
		this.postid = postid;
		this.commentid = commentid;
	}

	@Override
	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CommentId))
			return false;
		CommentId castOther = (CommentId) other;

		return ((this.getPostid() == castOther.getPostid()) || (this.getPostid() != null
				&& castOther.getPostid() != null && this.getPostid().equals(castOther.getPostid())))
				&& ((this.getCommentid() == castOther.getCommentid()) || (this.getCommentid() != null
						&& castOther.getCommentid() != null && this.getCommentid().equals(castOther.getCommentid())));
	}

	@Column(name = "commentid", unique = true, nullable = false, length = 100)
	public String getCommentid() {
		return this.commentid;
	}

	@Column(name = "postid", nullable = false, length = 100)
	public String getPostid() {
		return this.postid;
	}

	@Override
	public int hashCode() {
		int result = 17;

		result = 37 * result + (getPostid() == null ? 0 : this.getPostid().hashCode());
		result = 37 * result + (getCommentid() == null ? 0 : this.getCommentid().hashCode());
		return result;
	}

	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}

	public void setPostid(String postid) {
		this.postid = postid;
	}

}
