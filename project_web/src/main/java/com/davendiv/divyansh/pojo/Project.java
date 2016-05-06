package com.davendiv.divyansh.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "project", catalog = "davendiv")
public class Project implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private String projectid;
	private Education education;
	private Experience experience;
	private String title;
	private Date startdate;
	private Date enddate;
	private String projectdetail;

	public Project() {
	}

	public Project(String projectid, Education education, Experience experience, String title, Date startdate,
			Date enddate, String projectdetail) {
		this.projectid = projectid;
		this.education = education;
		this.experience = experience;
		this.title = title;
		this.startdate = startdate;
		this.enddate = enddate;
		this.projectdetail = projectdetail;
	}

	public Project(String projectid, String title) {
		this.projectid = projectid;
		this.title = title;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "eduid")
	public Education getEducation() {
		return this.education;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "enddate", length = 19)
	public Date getEnddate() {
		return this.enddate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "expid")
	public Experience getExperience() {
		return this.experience;
	}

	@Column(name = "projectdetail", length = 500)
	public String getProjectdetail() {
		return this.projectdetail;
	}

	@Id

	@Column(name = "projectid", unique = true, nullable = false, length = 50)
	public String getProjectid() {
		return this.projectid;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "startdate", length = 19)
	public Date getStartdate() {
		return this.startdate;
	}

	@Column(name = "title", nullable = false, length = 200)
	public String getTitle() {
		return this.title;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}

	public void setProjectdetail(String projectdetail) {
		this.projectdetail = projectdetail;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
