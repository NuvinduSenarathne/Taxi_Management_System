package com.EasyTaxiCTRL.model;

public class OwnerPayment extends Payment {
	private int ownerid;
	private float chargePerKM;
	private int noOfKM;
	private String date;
	private float payment = chargePerKM * noOfKM;
	
	public OwnerPayment(int paymentID, String vehiclename, int ownerid, float chargePerKM, int noOfKM, String date) {
		super(paymentID, vehiclename);
		this.ownerid = ownerid;
		this.chargePerKM = chargePerKM;
		this.noOfKM = noOfKM;
		this.date = date;

	}
	
	public OwnerPayment(String vehiclename, int ownerid, String date, float chargePerKM, int noOfKM) {
		super(vehiclename);
		this.ownerid = ownerid;
		this.chargePerKM = chargePerKM;
		this.noOfKM = noOfKM;
		this.date = date;
	}
	
	public OwnerPayment(String vehiclename, int ownerid, String date, float chargePerKM, int noOfKM, float payment) {
		super(vehiclename);
		this.ownerid = ownerid;
		this.chargePerKM = chargePerKM;
		this.noOfKM = noOfKM;
		this.date = date;
		this.payment = payment;
	}

	public int getOwnerid() {
		return ownerid;
	}

	public void setOwnerid(int ownerid) {
		this.ownerid = ownerid;
	}

	public float getChargePerKM() {
		return chargePerKM;
	}

	public void setChargePerKM(float chargePerKM) {
		this.chargePerKM = chargePerKM;
	}

	public int getNoOfKM() {
		return noOfKM;
	}

	public void setNoOfKM(int noOfKM) {
		this.noOfKM = noOfKM;
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
