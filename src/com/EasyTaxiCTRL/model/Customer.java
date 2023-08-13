package com.EasyTaxiCTRL.model;

public class Customer extends User {
	private String nic;
	
	public Customer(int userid, String firstname, String lastname, String email, String mobile, String nic) {
		super(userid, firstname, lastname, email, mobile);
		this.nic = nic;
	}
	
	public Customer(String firstname, String lastname, String email, String mobile, String nic) {
		super(firstname, lastname, email, mobile);
		this.nic = nic;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}
}
