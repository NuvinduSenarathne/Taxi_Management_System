package com.EasyTaxiCTRL.model;

public abstract class User {
	private int userid;
	private String firstname;
	private String lastname;
	private String email;
	private String mobile;
	
	public User(int userid, String firstname, String lastname, String email, String mobile) {
		super();
		this.userid = userid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobile = mobile;
	}
	
	public User(String firstname, String lastname, String email, String mobile) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobile = mobile;
	}

	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String fistname) {
		this.firstname = fistname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}