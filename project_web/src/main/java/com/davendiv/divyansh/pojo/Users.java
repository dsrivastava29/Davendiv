package com.davendiv.divyansh.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users", catalog = "davendiv")
public class Users implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	// private static long count=0;
	private long userid;

	private String uname;
	private String picture;
	private String logicalpic;
	private String pass;
	private String mail;
	private String timezone;
	private String language;
	private String theme;
	private String userUrl;
	private int isActive;
	private Inbox inbox;

	private PersonalInfo personalInfo = new PersonalInfo();

	private Set<Education> educations = new HashSet<Education>(0);

	private Set<Role> roles = new HashSet<Role>(0);
	private Set<Notification> notification = new HashSet<Notification>(0);
	private Set<Connectiondetails> connectiondetailses = new HashSet<Connectiondetails>(0);
	private Set<Experience> experiences = new HashSet<Experience>(0);
	private Set<Group> groups = new HashSet<Group>(0);
	private Set<Davenfeed> davenfeeds = new HashSet<Davenfeed>(0);
	private Set<Sessions> sessionses = new HashSet<Sessions>(0);

	public Users() {
		// userid=count++;
	}

	public Users(long userid, String uname, String pass, String mail) {

		this.userid = userid;

		this.uname = uname;
		this.pass = pass;
		this.mail = mail;
	}

	public Users(long userid, String uname, String pass, String mail, String timezone, String language, String theme,
			String userUrl, Inbox inbox, PersonalInfo personalInfo, Set<Education> educations, Set<Role> roles,
			Set<Connectiondetails> connectiondetailses, Set<Experience> experiences, Set<Group> groups,
			Set<Davenfeed> davenfeeds, Set<Sessions> sessionses) {

		this.userid = userid;

		this.uname = uname;
		this.pass = pass;
		this.mail = mail;
		this.timezone = timezone;
		this.language = language;
		this.theme = theme;
		this.userUrl = userUrl;
		this.inbox = inbox;
		this.personalInfo = personalInfo;
		this.educations = educations;
		this.roles = roles;
		this.connectiondetailses = connectiondetailses;
		this.experiences = experiences;
		this.groups = groups;
		this.davenfeeds = davenfeeds;
		this.sessionses = sessionses;
	}

	public Users(String uname, String pass, String mail) {

		this.uname = uname;
		this.pass = pass;
		this.mail = mail;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.REMOVE, orphanRemoval = true)
	public Set<Connectiondetails> getConnectiondetailses() {
		return this.connectiondetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.REMOVE, orphanRemoval = true)
	public Set<Davenfeed> getDavenfeeds() {
		return this.davenfeeds;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.REMOVE, orphanRemoval = true)
	public Set<Education> getEducations() {
		return this.educations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.REMOVE, orphanRemoval = true)
	public Set<Experience> getExperiences() {
		return this.experiences;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "usergroup", catalog = "davendiv", joinColumns = {
			@JoinColumn(name = "userid", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "groupid", nullable = false, updatable = false) })
	public Set<Group> getGroups() {
		return this.groups;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "users")
	public Inbox getInbox() {
		return this.inbox;
	}

	@Column(name = "accountstatus")
	public int getIsActive() {
		return isActive;
	}

	@Column(name = "language", length = 20)
	public String getLanguage() {
		return this.language;
	}

	@Column(name = "logicalpic")
	public String getLogicalpic() {
		return logicalpic;
	}

	@Column(name = "mail", length = 50)
	public String getMail() {
		return this.mail;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.REMOVE, orphanRemoval = true)
	public Set<Notification> getNotification() {
		return notification;
	}

	@Column(name = "pass", nullable = false, length = 20)
	public String getPass() {
		return this.pass;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "Personal_FK")
	public PersonalInfo getPersonalInfo() {
		return this.personalInfo;
	}

	@Column(name = "picture")
	public String getPicture() {
		return picture;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", catalog = "davendiv", joinColumns = {
			@JoinColumn(name = "userid", nullable = false, updatable = true) }, inverseJoinColumns = {
					@JoinColumn(name = "roleid", nullable = false, updatable = true) })
	public Set<Role> getRoles() {
		return this.roles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
	public Set<Sessions> getSessionses() {
		return this.sessionses;
	}

	@Column(name = "theme", length = 20)
	public String getTheme() {
		return this.theme;
	}

	@Column(name = "timezone", length = 20)
	public String getTimezone() {
		return this.timezone;
	}

	@Column(name = "uname", nullable = false, length = 50)
	public String getUname() {
		return this.uname;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid", unique = true, nullable = false)
	public long getUserid() {
		return this.userid;
	}

	@Column(name = "user_url", length = 20)
	public String getUserUrl() {
		return this.userUrl;
	}

	public void setConnectiondetailses(Set<Connectiondetails> connectiondetailses) {
		this.connectiondetailses = connectiondetailses;
	}

	public void setDavenfeeds(Set<Davenfeed> davenfeeds) {
		this.davenfeeds = davenfeeds;
	}

	public void setEducations(Set<Education> educations) {
		this.educations = educations;
	}

	public void setExperiences(Set<Experience> experiences) {
		this.experiences = experiences;
	}

	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}

	public void setInbox(Inbox inbox) {
		this.inbox = inbox;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setLogicalpic(String logicalpic) {
		this.logicalpic = logicalpic;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setNotification(Set<Notification> notification) {
		this.notification = notification;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setSessionses(Set<Sessions> sessionses) {
		this.sessionses = sessionses;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public void setUserUrl(String userUrl) {
		this.userUrl = userUrl;
	}

}
