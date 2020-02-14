package com.example.demo.response;

import java.math.BigDecimal;

public class GetStockResponse {
	private String company_name;
	private String watertype;
	private Integer liter;
	private BigDecimal quantity;
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getWatertype() {
		return watertype;
	}
	public void setWatertype(String watertype) {
		this.watertype = watertype;
	}
	public Integer getLiter() {
		return liter;
	}
	public void setLiter(Integer liter) {
		this.liter = liter;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	
	
}
