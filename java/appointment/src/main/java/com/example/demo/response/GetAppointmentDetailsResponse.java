package com.example.demo.response;

public class GetAppointmentDetailsResponse {
	private String firstname;
	private String lastname;
	private String mobile;
	private String appointmentdate;
	private Integer tokenno;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAppointmentdate() {
		return appointmentdate;
	}
	public void setAppointmentdate(String appointmentdate) {
		this.appointmentdate = appointmentdate;
	}
	public Integer getTokenno() {
		return tokenno;
	}
	public void setTokenno(Integer tokenno) {
		this.tokenno = tokenno;
	}
	
	
}
