package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.FindLocationResponse;
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
	
	@PostMapping("/add_pass/{passenger_id}/{from}/{to}/{next}/{amount}")
	public String add_pass(@PathVariable Integer passenger_id,
			@PathVariable String from,
			@PathVariable String  to,
			@PathVariable String  next,
			@PathVariable Integer amount) {
		service.add_pass(passenger_id,from,to,next,amount);
		return "Pass Registration Saved Sucessfully";
	}
	
	@PostMapping("/add_general/{passenger_id}/{from}/{to}/{amount}")
	public String add_general(@PathVariable Integer passenger_id,
			@PathVariable String from,
			@PathVariable String  to,
			@PathVariable Integer amount) {
		service.add_general(passenger_id,from,to,amount);
		return "General Ticket Saved Sucessfully";
	}
	
	@PostMapping("/add_train/{trainno}/{trainname}/{from}/{to}")
	public String add_train(@PathVariable Integer trainno,
			@PathVariable String trainname,
			@PathVariable String  from,
			@PathVariable String to) {
		service.add_train(trainno,trainname,from,to);
		return "Train Saved Sucessfully";
	}
	
	@PostMapping("/location_update/{trainid}/{location}")
	public String location_update(@PathVariable Integer trainid,@PathVariable String location) {
		service.location_update(trainid,location);
		return "Train Location updated Sucessfully";
	}
	
	
	@PostMapping("/find_location/{trainno}")
	public ResponseEntity<List<FindLocationResponse>> find_location(@PathVariable Integer trainno) {
		
		return ResponseEntity.ok().body(service.find_location(trainno));
	}
	
}
