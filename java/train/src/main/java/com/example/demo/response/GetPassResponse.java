package com.example.demo.response;

public class GetPassResponse {
	private Integer id;
	private String fromLocation;
	private String toLocation;
	private String nextRenewal;
	private Integer amount;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFromLocation() {
		return fromLocation;
	}
	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}
	public String getToLocation() {
		return toLocation;
	}
	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}
	public String getNextRenewal() {
		return nextRenewal;
	}
	public void setNextRenewal(String nextRenewal) {
		this.nextRenewal = nextRenewal;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	

}
