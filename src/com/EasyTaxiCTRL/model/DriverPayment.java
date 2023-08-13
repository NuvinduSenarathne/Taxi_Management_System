package com.EasyTaxiCTRL.model;

public class DriverPayment extends Payment {
	private int driverid;
	private String date;
	private float payment;
	
	public DriverPayment(int paymentid, String vehiclename, int driverid, String date, float payment) {
		super(paymentid, vehiclename);
		this.driverid = driverid;
		this.date = date;
		this.payment = payment;
	}
	
	public DriverPayment(String vehiclename, int driverid, String date, float payment) {
		super(vehiclename);
		this.driverid = driverid;
		this.date = date;
		this.payment = payment;
	}

	public int getDriverid() {
		return driverid;
	}

	public void setDriverID(int driverid) {
		this.driverid = driverid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setPayment(float payment) {
		this.payment = payment;
	}

	public float getPayment() {
		return payment;
	}
}
