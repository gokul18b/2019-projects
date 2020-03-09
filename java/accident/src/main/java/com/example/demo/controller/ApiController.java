package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.ViewAllocateHistoryResponse;
import com.example.demo.response.ViewCaseResponse;
import com.example.demo.response.ViewCriminalResponse;
import com.example.demo.response.ViewPoliceResponse;
import com.example.demo.service.ApiService;

@RestController
@RequestMapping(value = { "/api" })
public class ApiController {

	@Autowired
	ApiService service;

	@GetMapping("/login/{username}/{password}")
	public Integer login(@PathVariable String username, @PathVariable String password) {
		return service.login(username, password);
	}

	@PostMapping("/add_police/{firstname}/{lastname}/{department}/{profession}" + "/{username}/{password}/{address}")
	public String add_police(@PathVariable String firstname, @PathVariable String lastname,
			@PathVariable String department, @PathVariable String profession, @PathVariable String username,
			@PathVariable String password, @PathVariable String address) {
		service.add_police(firstname, lastname, department, profession, username, password, address);
		return "Police Saved Sucessfully";
	}

	@GetMapping("/view_police")
	public ResponseEntity<List<ViewPoliceResponse>> view_police() {

		return ResponseEntity.ok().body(service.view_police());
	}

	@PostMapping("/add_criminal/{firstname}/{lastname}/{mobile}/{aadhar}" + "/{address}")
	public String add_criminal(@PathVariable String firstname, @PathVariable String lastname,
			@PathVariable String mobile, @PathVariable String aadhar, @PathVariable String address) {
		service.add_criminal(firstname, lastname, mobile, aadhar, address);
		return "Criminal Saved Sucessfully";
	}

	@GetMapping("/view_criminal")
	public ResponseEntity<List<ViewCriminalResponse>> view_criminal() {
		return ResponseEntity.ok().body(service.view_criminal());
	}

	@PostMapping("/add_case/{casename}/{description}")
	public String add_case(@PathVariable String casename, @PathVariable String description) {
		service.add_case(casename, description);
		return "Case name Saved Sucessfully";
	}

	@GetMapping("/view_case")
	public ResponseEntity<List<ViewCaseResponse>> view_case() {
		return ResponseEntity.ok().body(service.view_case());
	}

	@GetMapping("/get_criminal/{aadhar}")
	public ResponseEntity<List<ViewCriminalResponse>> get_criminal(@PathVariable String aadhar) {
		return ResponseEntity.ok().body(service.get_criminal(aadhar));
	}

	@PostMapping("/allocate_case/{criminal_id}/{case_id}/{personname}/{vehicleno}"
			+ "/{mobile}/{address}/{description}")
	public String allocate_case(@PathVariable Integer criminal_id, @PathVariable Integer case_id,
			@PathVariable String personname, @PathVariable String vehicleno, @PathVariable String mobile,
			@PathVariable String address, @PathVariable String description) {
		service.allocate_case(criminal_id, case_id, personname, vehicleno, mobile, address, description);
		return "Case Allocated Sucessfully";
	}

	@GetMapping("/allocate_history/{aadhar}")
	public ResponseEntity<List<ViewAllocateHistoryResponse>> allocate_history(@PathVariable String aadhar) {
		return ResponseEntity.ok().body(service.allocate_history(aadhar));
	}
}
