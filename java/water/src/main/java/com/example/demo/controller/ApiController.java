package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.GetBillingResponse;
import com.example.demo.response.GetCustomerResponse;
import com.example.demo.response.GetProductResponse;
import com.example.demo.response.GetStockResponse;
import com.example.demo.service.ApiService;


@RestController
@RequestMapping(value = { "/api" })
public class ApiController {

	@Autowired
	ApiService service;

	@GetMapping("/login/{username}/{password}")
	public Boolean login(@PathVariable String username,@PathVariable String password) {
		return service.login(username,password);
	}
	
	
	@PostMapping("/add_customer/{name}/{mobile}/{address}/{gender}/{email}")
	public String add_customer(@PathVariable String name,
			@PathVariable String mobile,
			@PathVariable String  address,
			@PathVariable String gender,
			@PathVariable String email) {
		service.add_customer(name,mobile,address,gender,email);
		return "Customer Saved Sucessfully";
	}
	

	@PostMapping("/add_water_types/{company}/{type}/{liter}/{price}")
	public String add_water_types(@PathVariable String company,
			@PathVariable String type,
			@PathVariable Integer  liter,
			@PathVariable Integer  price) {
		service.add_water_types(company,type,liter,price);
		return "Water type added sucessfully";
	}
	
	
	@GetMapping("/get_water")
	public ResponseEntity<List<GetProductResponse>> get_water() {
		return ResponseEntity.ok().body(service.get_water());
	}
	
	
	@PostMapping("/add_purchase/{product_id}/{quantity}/{price}")
	public String add_purchase(@PathVariable Integer product_id,
			@PathVariable Integer  quantity,
			@PathVariable Integer  price) {
		service.add_purchase(product_id,quantity,price);
		return "Purchase Saved Sucessfully";
	}
	
	@PostMapping("/add_sales/{customer_id}/{product_id}/{quantity}/{price}")
	public String add_sales(@PathVariable Integer customer_id,@PathVariable Integer product_id,
			@PathVariable Integer  quantity,@PathVariable Integer  price) {
		return service.add_sales(customer_id,product_id,quantity,price);
		
	}
	
	@GetMapping("/get_customer/{mobile}")
	public List<Object[]> get_mobile(@PathVariable String mobile) {
		return service.get_mobile(mobile);
	}
	
	@GetMapping("/get_stock")
	public ResponseEntity<List<GetStockResponse>> get_stock() {
		return ResponseEntity.ok().body(service.get_stock());
	}
	@GetMapping("/get_billing")
	public ResponseEntity<List<GetBillingResponse>> get_billing() {
		return ResponseEntity.ok().body(service.get_billing());
	}
	
}
