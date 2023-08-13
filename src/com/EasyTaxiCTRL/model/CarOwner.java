package com.EasyTaxiCTRL.model;

public class CarOwner extends User {

	public CarOwner(int userid, String firstname, String lastname, String email, String mobile, String nic) {
		super(userid, firstname, lastname, email, mobile);
		this.nic = nic;
	}
	
	public CarOwner(String firstname, String lastname, String email, String mobile, String nic) {
		super(firstname, lastname, email, mobile);
		this.nic = nic;
	}

	private String nic;

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}
}
