package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.GetClassResponse;
import com.example.demo.response.GetDepartmentClassResponse;
import com.example.demo.response.GetDepartmentResponse;
import com.example.demo.response.GetStudentResponse;
import com.example.demo.service.ApiService;


@RestController
@RequestMapping(value = { "/api" })
public class ApiController {

	@Autowired
	ApiService service;

	@GetMapping("/test")
	public String test() {
		return "test";
	}
	@PostMapping("/student_register/{firstname}/{lastname}/{mobile}/{email}/{age}/{gender}/{address}/{ten}/{twelve}/{schoolname}/{father}/{mother}/{department}/{classname}")
	public String student_register(@PathVariable String firstname,
			@PathVariable String lastname,
			@PathVariable String mobile,
			@PathVariable String email,
			@PathVariable Integer age,
			@PathVariable String gender,
			@PathVariable String address,
			@PathVariable Integer ten,
			@PathVariable Integer twelve,
			@PathVariable String schoolname,
			@PathVariable String father,
			@PathVariable String mother,
			@PathVariable String department,
			@PathVariable String classname) {
		service.student_register(firstname,lastname,mobile,email,age,gender,address,ten,twelve,schoolname,father,mother,department,classname);
		return "Student Sucessfully Registered";
	}
	
	
	@PostMapping("/add_department/{department}/{classname}/{seat}")
	public String add_department(@PathVariable String department,
			@PathVariable String classname,
			@PathVariable Integer seat) {
		service.add_department(department,classname,seat);
		return "Department Saved Sucessfully";
	}
	
	@GetMapping("/get_department")
	public ResponseEntity<List<GetDepartmentResponse>> get_department() {
		
		return ResponseEntity.ok().body(service.get_department());
	}
	@GetMapping("/get_class")
	public ResponseEntity<List<GetClassResponse>> get_class() {
		
		return ResponseEntity.ok().body(service.get_class());
	}
	@GetMapping("/get_department_class")
	public ResponseEntity<List<GetDepartmentClassResponse>> get_department_class() {
		
		return ResponseEntity.ok().body(service.get_department_class());
	}
	
	
	@GetMapping("/show_pending_student/{department}/{classname}")
	public ResponseEntity<List<GetStudentResponse>> show_pending_student(@PathVariable String department,@PathVariable String classname) {
		
		return ResponseEntity.ok().body(service.show_pending_student(department,classname));
	}
	
	@GetMapping("/approve/{id}/{department}/{classname}")
	public String approve(@PathVariable Integer id,@PathVariable String department,@PathVariable String classname) {
		return service.approve(id,department,classname);
		
	}
	
	@GetMapping("/reject/{id}")
	public String reject(@PathVariable Integer id) {
		service.reject(id);
		return "Student Has  remved";
	}
	
	
	
	
}
