package com.example.demo.response;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class viewBillResponse {
	private String name;
	private Integer amount;
	@JsonFormat(pattern="dd-MM-yyyy HH:mm a")
	private Timestamp date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
}
