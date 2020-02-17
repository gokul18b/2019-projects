package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.GetAppointmentDetailsResponse;
import com.example.demo.response.GetBillingResponse;
import com.example.demo.response.GetCustomerResponse;
import com.example.demo.response.GetDoctorListResponse;
import com.example.demo.response.GetEmployeeResponse;
import com.example.demo.response.GetPatientResponse;
import com.example.demo.response.GetProductResponse;
import com.example.demo.response.GetStockResponse;
import com.example.demo.service.ApiService;


@RestController
@RequestMapping(value = { "/api" })
public class ApiController {

	@Autowired
	ApiService service;

	@GetMapping("/login/{username}/{password}")
	public Integer login(@PathVariable String username,@PathVariable String password) {
		List<Object[]> res = service.login(username,password);
		if(res.size()==0) {
			return 0;
		}else {
			return (Integer)res.get(0)[0];
		}
	}
	
	
	@PostMapping("/add_patient/{firstname}/{lastname}/{mobile}/{email}/{attendar}/{emergency}")
	public String add_patient(@PathVariable String firstname,
			@PathVariable String lastname,
			@PathVariable String  mobile,
			@PathVariable String email,
			@PathVariable String attendar,
			@PathVariable String emergency) {
		service.add_patient(firstname,lastname,mobile,email,attendar,emergency);
		return "Patient Saved Sucessfully";
	}
	
	@PostMapping("/adddoctor/{doctorname}/{qualification}/{speciality}/{username}/{password}")
	public String adddoctor(@PathVariable String doctorname,
			@PathVariable String qualification,
			@PathVariable String  speciality,
			@PathVariable String username,
			@PathVariable String password) {
		service.adddoctor(doctorname,qualification,speciality,username,password);
		return "Doctor Saved Sucessfully";
	}
	
	@GetMapping("/get_patient/{mobile}")
	public ResponseEntity<GetPatientResponse> get_mobile(@PathVariable String mobile) {
		return ResponseEntity.ok().body(service.get_patient(mobile));
	}
	
	@PostMapping("/book_appointment/{doctor_id}/{patient_id}/{amount}/{appointment_date}")
	public String book_appointment(
			@PathVariable Integer doctor_id,
			@PathVariable Integer  patient_id,
			@PathVariable Integer amount,
			@PathVariable String appointment_date) {
		service.book_appointment(doctor_id,patient_id,amount,appointment_date);
		return "Appointment Booked  Sucessfully";
	}

	@GetMapping("/get_doctorlist")
	public ResponseEntity<List<GetDoctorListResponse>> get_doctorlist() {
		return ResponseEntity.ok().body(service.get_doctorlist());
	}
	
	@GetMapping("/get_appointment_details_doctor/{id}/{date}")
	public ResponseEntity<List<GetAppointmentDetailsResponse>> get_appointment_details_doctor(@PathVariable Integer id,@PathVariable String date) {
		return ResponseEntity.ok().body(service.get_appointment_details_doctor(id,date));
	}
}
