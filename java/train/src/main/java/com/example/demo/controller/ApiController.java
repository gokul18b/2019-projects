package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.GetPassengerResponse;
import com.example.demo.service.ApiService;


@RestController
@RequestMapping(value = { "/api" })
public class ApiController {

	@Autowired
	ApiService service;

//	@GetMapping("/login/{username}/{password}")
//	public Boolean login(@PathVariable String username,@PathVariable String password) {
//		return service.login(username,password);
//	}
	
	
	@PostMapping("/add_passenger/{firstname}/{lastname}/{mobile}/{email}"
			+ "/{username}/{password}/{idproof}/{address}")
	public String add_passenger(@PathVariable String firstname,
			@PathVariable String lastname,
			@PathVariable String  mobile,
			@PathVariable String email,
			@PathVariable String username,
			@PathVariable String password,
			@PathVariable String  idproof,
			@PathVariable String address) {
		service.add_passenger(firstname,lastname,mobile,email,username,password
				,idproof,address);
		return "Passenger Saved Sucessfully";
	}
	
	
	@GetMapping("/get_passenger/{mobile}")
	public ResponseEntity<List<GetPassengerResponse>> get_passenger(@PathVariable String mobile) {
		
		return ResponseEntity.ok().body(service.get_passenger(mobile));
	}
	
}
