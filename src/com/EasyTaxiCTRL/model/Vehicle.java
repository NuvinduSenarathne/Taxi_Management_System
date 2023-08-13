package com.EasyTaxiCTRL.model;

//vehicle model...

public class Vehicle {
	private int vehicleid;
	private String vehiclename;
	private String regno;
	private int manufactureyear;
	private String district;
	private String vehicletype;
	private String vehiclecondition;
	private int passengers;
	private String imgURL;
	
	public Vehicle(int vehicleid, String vehiclename, String regno, int manufactureyear, String district,
			String vehicletype, String vehiclecondition, int passengers, String imgURL) {
		super();
		this.vehicleid = vehicleid;
		this.vehiclename = vehiclename;
		this.regno = regno;
		this.manufactureyear = manufactureyear;
		this.district = district;
		this.vehicletype = vehicletype;
		this.vehiclecondition = vehiclecondition;
		this.passengers = passengers;
		this.imgURL = imgURL;
	}

	public Vehicle(String vehiclename, String regno, int manufactureyear, String district, String vehicletype,
			String vehiclecondition, int passengers, String imgURL) {
		super();
		this.vehiclename = vehiclename;
		this.regno = regno;
		this.manufactureyear = manufactureyear;
		this.district = district;
		this.vehicletype = vehicletype;
		this.vehiclecondition = vehiclecondition;
		this.passengers = passengers;
		this.imgURL = imgURL;
	}

	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehiclid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	public String getVehiclename() {
		return vehiclename;
	}

	public void setVehiclename(String vehiclename) {
		this.vehiclename = vehiclename;
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public int getManufactureyear() {
		return manufactureyear;
	}

	public void setManufactureyear(int manufactureyear) {
		this.manufactureyear = manufactureyear;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	public String getVehiclecondition() {
		return vehiclecondition;
	}

	public void setVehiclecondition(String vehiclecondition) {
		this.vehiclecondition = vehiclecondition;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	
}
