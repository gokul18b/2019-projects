package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.LoginResponse;
import com.example.demo.response.ViewBranchResponse;
import com.example.demo.response.ViewUserResponse;
import com.example.demo.service.ApiService;


@RestController
@RequestMapping(value = { "/api" })
public class ApiController {

	@Autowired
	ApiService service;

	@PostMapping("/login/{username}/{password}")
	public ResponseEntity<List<LoginResponse>>  login(@PathVariable String username,@PathVariable String password) {
		return ResponseEntity.ok().body(service.login(username,password));
	}
	
	@GetMapping("/viewBranch")
	public ResponseEntity<List<ViewBranchResponse>>  viewBranch() {
		return ResponseEntity.ok().body(service.viewBranch());
	}
	
	@PostMapping("/addBranch/{name}/{landmark}/{pincode}/{address}")
	public String  addBranch(@PathVariable String name,@PathVariable String landmark,@PathVariable String pincode,@PathVariable String address) {
		service.addBranch(name,landmark,pincode,address);
		return "Branch sucessfully Created";
	}
	
	@PostMapping("/deleteBranch/{id}")
	public String  deleteBranch(@PathVariable String id) {
		service.deleteBranch(id);
		return "Branch sucessfully Removed";
	}
	
	
	@PostMapping("/addUser/{name}/{mobile}/{password}/{address}")
	public String  addUser(@PathVariable String name,@PathVariable String mobile,@PathVariable String password,@PathVariable String address) {
		service.addUser(name,mobile,password,address);
		return "User sucessfully Created";
	}
	
	
	@GetMapping("/viewUser")
	public ResponseEntity<List<ViewUserResponse>>  viewUser() {
		return ResponseEntity.ok().body(service.viewUser());
	}
	
	
	@PostMapping("/deleteUser/{id}")
	public String  addUser(@PathVariable Integer id) {
		service.deleteUser(id);
		return "User sucessfully Deleted";
	}
}
