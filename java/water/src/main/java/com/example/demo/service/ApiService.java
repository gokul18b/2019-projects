package com.example.demo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ApiDao;
import com.example.demo.response.GetBillingResponse;
import com.example.demo.response.GetCustomerResponse;
import com.example.demo.response.GetEmployeeResponse;
import com.example.demo.response.GetProductResponse;
import com.example.demo.response.GetStockResponse;

@Service
@Transactional
public class ApiService {

	@Autowired
	ApiDao dao;

	

	public void add_customer(String name, String mobile, String address, String gender, String email) {
		// TODO Auto-generated method stub
		dao.add_customer(name,mobile,address,gender,email);
		
	}

	public Boolean login(String username, String password) {
		
		return dao.login(username,password);
	}

	public void add_water_types(String company, String type, Integer liter, Integer price) {
		dao.add_water_types(company,type,liter,price);
		
	}
	
	
	public void add_purchase(Integer product_id, Integer quantity, Integer price) {
		// TODO Auto-generated method stub
		dao.add_purchase(product_id,quantity,price);
	}

	public String add_sales(Integer customer_id, Integer product_id, Integer quantity, Integer price) {
		// TODO Auto-generated method stub
		return dao.add_sales(customer_id,product_id,quantity,price);
	}

	public List<GetStockResponse> get_stock() {
		List<Object[]> result =dao.get_stock();
		
		List<GetStockResponse> response = new ArrayList<GetStockResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			GetStockResponse obj = new GetStockResponse();
			obj.setCompany_name((String)row[0]);
			obj.setWatertype((String)row[1]);
			obj.setLiter((Integer)row[2]);
			obj.setQuantity((BigDecimal)row[3]);
			
			response.add(obj);
			
		}
		return response;
	}

	public List<Object[]> get_mobile(String mobile) {
		// TODO Auto-generated method stub
		 List<Object[]> result = dao.get_mobile(mobile);
		GetCustomerResponse response = new GetCustomerResponse();
		
			return result;
		
	}

	

	public List<GetBillingResponse> get_billing() {
		List<Object[]> result =dao.get_billing();
		
		List<GetBillingResponse> response = new ArrayList<GetBillingResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			GetBillingResponse obj = new GetBillingResponse();
			obj.setCustomer_name((String)row[0]);
			obj.setMobile((String)row[1]);
			obj.setCompany((String)row[2]);
			obj.setWatertype((String)row[3]);
			obj.setQuantity((Integer)row[4]);
			obj.setPrice((Integer)row[5]);
			
			response.add(obj);
			
		}
		return response;
	}

	public List<GetProductResponse> get_water() {
		// TODO Auto-generated method stub
		List<Object[]> result =dao.get_water();
		
		List<GetProductResponse> response = new ArrayList<GetProductResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			GetProductResponse obj = new GetProductResponse();
			obj.setId((Integer)row[0]);
			obj.setCompany((String)row[1]);
			obj.setWatertype((String)row[2]);
			obj.setLiter((Integer)row[3]);
			obj.setPrice((Integer)row[4]);
			
			response.add(obj);
			
		}
		return response;
	}

	
	
}
