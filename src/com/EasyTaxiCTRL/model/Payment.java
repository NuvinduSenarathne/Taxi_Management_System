package com.EasyTaxiCTRL.model;

abstract class Payment {
	private int paymentid;
	private String vehiclename;
	
	public Payment(int paymentid, String vehiclename) {
		super();
		this.paymentid = paymentid;
		this.vehiclename = vehiclename;
	}
	
	public Payment(String vehiclename) {
		super();
		this.vehiclename = vehiclename;
	}

	public int getPaymentid() {
		return paymentid;
	}

	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}
	
	public String getVehiclename() {
		return vehiclename;
	}

	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}

	abstract public float getPayment();
}