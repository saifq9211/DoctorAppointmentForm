package com.saif.appointment;


public class AppointmentBean {
	private String name;
	private int age;
	private String DOB;
	private String group;
	private String address;
	private int mobile;
	private String email;
	private String dateOfAppointment;
	public AppointmentBean(String name, int age, String dOB, String group, String address, int mobile, String email,
			String dateOfAppointment) {
		super();
		this.name = name;
		this.age = age;
		DOB = dOB;
		this.group = group;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.dateOfAppointment = dateOfAppointment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getMobile() {
		return mobile;
	}
	public void setMobile(int mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateOfAppointment() {
		return dateOfAppointment;
	}
	public void setStringOfAppointment(String dateOfAppointment) {
		this.dateOfAppointment = dateOfAppointment;
	}

	
	
	
	
	
	
}
