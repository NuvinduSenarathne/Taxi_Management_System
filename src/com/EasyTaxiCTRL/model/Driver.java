package com.EasyTaxiCTRL.model;

public class Driver extends User {
	private String licenseNo;
	
	
	public Driver(int userid, String firstname, String lastname, String email, String mobile, String licenseNo) {
		super(userid, firstname, lastname, email, mobile);
		this.licenseNo = licenseNo;
	}
	
	public Driver(String firstname, String lastname, String email, String mobile, String licenseNo) {
		super(firstname, lastname, email, mobile);
		this.licenseNo = licenseNo;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
}
