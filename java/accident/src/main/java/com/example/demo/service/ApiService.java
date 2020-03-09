package com.example.demo.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ApiDao;
import com.example.demo.response.ViewAllocateHistoryResponse;
import com.example.demo.response.ViewCaseResponse;
import com.example.demo.response.ViewCriminalResponse;
import com.example.demo.response.ViewPoliceResponse;

@Service
@Transactional
public class ApiService {

	@Autowired
	ApiDao dao;

	public void add_police(String firstname, String lastname, String department, String profession, String username,
			String password, String address) {
		// TODO Auto-generated method stub
		dao.add_police(firstname,lastname,department,profession,username,password
				,address);
	}


	public List<ViewPoliceResponse> view_police() {
	// TODO Auto-generated method stub
	List<Object[]> result =dao.view_police();
	
	List<ViewPoliceResponse> response = new ArrayList<ViewPoliceResponse>();
	for(int i=0;i<result.size();i++) {
		Object[] row = result.get(i);
		ViewPoliceResponse obj = new ViewPoliceResponse();
		
		obj.setFirstname((String) row[1]);
		obj.setLastname((String) row[2]);
		obj.setDepartment((String) row[3]);
		obj.setProfession((String) row[4]);
		
		response.add(obj);
	}
	return response;
}


	public void add_criminal(String firstname, String lastname, String mobile, String aadhar, String address) {
		// TODO Auto-generated method stub
		dao.add_criminal(firstname,lastname,mobile,aadhar,address);
	}


	public List<ViewCriminalResponse> view_criminal() {
		// TODO Auto-generated method stub
		List<Object[]> result =dao.view_criminal();
		
		List<ViewCriminalResponse> response = new ArrayList<ViewCriminalResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			ViewCriminalResponse obj = new ViewCriminalResponse();
			obj.setId((Integer)row[0]);
			obj.setFirstname((String) row[1]);
			obj.setLastname((String) row[2]);
			obj.setMobile((String) row[3]);
			obj.setAadhar((String) row[4]);
			obj.setAddress((String) row[5]);
			
			response.add(obj);
		}
		return response;
	}


	public void add_case(String casename, String description) {
		// TODO Auto-generated method stub
		dao.add_case(casename,description);
	}


	public List<ViewCaseResponse> view_case() {
		// TODO Auto-generated method stub
		List<Object[]> result =dao.view_case();
		
		List<ViewCaseResponse> response = new ArrayList<ViewCaseResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			ViewCaseResponse obj = new ViewCaseResponse();
			obj.setId((Integer)row[0]);
			obj.setCasename((String) row[1]);
			obj.setDescription((String) row[2]);
			
			
			response.add(obj);
		}
		return response;
	}


	public List<ViewCriminalResponse> get_criminal(String aadhar) {
		// TODO Auto-generated method stub
List<Object[]> result =dao.get_criminal(aadhar);
		
		List<ViewCriminalResponse> response = new ArrayList<ViewCriminalResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			ViewCriminalResponse obj = new ViewCriminalResponse();
			obj.setId((Integer)row[0]);
			obj.setFirstname((String) row[1]);
			obj.setLastname((String) row[2]);
			obj.setMobile((String) row[3]);
			obj.setAadhar((String) row[4]);
			obj.setAddress((String) row[5]);
			
			response.add(obj);
		}
		return response;
	}


	public void allocate_case(Integer criminal_id, Integer case_id, String personname, String vehicleno, String mobile,
			String address, String description) {
		// TODO Auto-generated method stub
		dao.allocate_case(criminal_id,case_id,personname,vehicleno,mobile,address,description);
	}


	public List<ViewAllocateHistoryResponse> allocate_history(String aadhar) {
		// TODO Auto-generated method stub
List<Object[]> result =dao.allocate_history(aadhar);
		
		List<ViewAllocateHistoryResponse> response = new ArrayList<ViewAllocateHistoryResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			ViewAllocateHistoryResponse obj = new ViewAllocateHistoryResponse();
			//obj.setId((Integer)row[0]);
			obj.setPersonname((String) row[0]);
			obj.setVehicle((String) row[1]);
			obj.setMobile((String) row[2]);
			obj.setDescription((String) row[3]);
			obj.setDate((Timestamp) row[4]);
			obj.setCasename((String) row[5]);
			
			response.add(obj);
		}
		return response;
	}


	public Integer login(String username, String password) {
		// TODO Auto-generated method stub
		return dao.login(username,password);
	}

	
	




	
	
}
