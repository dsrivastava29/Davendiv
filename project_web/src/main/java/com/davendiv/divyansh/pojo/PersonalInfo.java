package com.davendiv.divyansh.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "personal_info", catalog = "davendiv")
public class PersonalInfo implements java.io.Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private long personid;
	private Users users;
	private String firstname;
	private String middlename;
	private String lastname;
	private String city;
	private String state;
	private String country;
	private Long phone;

	public PersonalInfo() {
	}

	public PersonalInfo(Users users, String firstname, String state, String country) {
		// this.users = users;
		this.firstname = firstname;
		this.state = state;
		this.country = country;
	}

	public PersonalInfo(Users users, String firstname, String middlename, String lastname, String city, String state,
			String country, Long phone) {
		// this.users = users;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.city = city;
		this.state = state;
		this.country = country;
		this.phone = phone;
	}

	@Column(name = "city", length = 20)
	public String getCity() {
		return this.city;
	}

	@Column(name = "country", length = 20)
	public String getCountry() {
		return this.country;
	}

	@Column(name = "firstname", length = 50)
	public String getFirstname() {
		return this.firstname;
	}

	@Column(name = "lastname", length = 50)
	public String getLastname() {
		return this.lastname;
	}

	@Column(name = "middlename", length = 50)
	public String getMiddlename() {
		return this.middlename;
	}

	@Id
	@GeneratedValue
	@Column(name = "personid", unique = true, nullable = false)
	public long getPersonid() {
		return this.personid;
	}

	@Column(name = "phone")
	public Long getPhone() {
		return this.phone;
	}

	@Column(name = "state", length = 20)
	public String getState() {
		return this.state;
	}

	@OneToOne(mappedBy = "personalInfo", cascade = CascadeType.ALL)
	public Users getUsers() {
		return users;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public void setPersonid(long personid) {
		this.personid = personid;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
