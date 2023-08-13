package com.EasyTaxiCTRL.model;

public class Employee {
	private int empid;
	private String firstname;
	private String lastname;
	private String address;
	private String email;
	private String mobile;
	private float salary;
	
	//Parameterized constructor with EmpID
	public Employee(int empid, String firstname, String lastname, String address, String email, String mobile,
			float salary) {
		super();
		this.empid = empid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.salary = salary;
	}
	
	//Parameterized constructor without EmpID
	public Employee(String firstname, String lastname, String address, String email, String mobile, float salary) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
		this.salary = salary;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}
}
