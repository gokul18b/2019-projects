package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ApiDao;
import com.example.demo.response.LoginResponse;
import com.example.demo.response.ViewBranchResponse;
import com.example.demo.response.ViewUserResponse;

@Service
@Transactional
public class ApiService {

	@Autowired
	ApiDao dao;
	
	public List<LoginResponse> login(String username, String password) {
		List<Object[]> result = dao.login(username,password);
		List<LoginResponse> response = new ArrayList<LoginResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			LoginResponse obj = new LoginResponse();
			
			obj.setId((Integer)row[0]);
			obj.setName((String)row[1]);
			obj.setMobile((String)row[2]);
			obj.setPassword((String)row[3]);
			obj.setAddress((String)row[4]);
			obj.setFLAG((Integer)row[5]);
			
			response.add(obj);
			
		}
		return response;
	}
	
	

	public List<ViewBranchResponse> viewBranch() {
		List<Object[]> result = dao.viewBranch();
		List<ViewBranchResponse> response = new ArrayList<ViewBranchResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			ViewBranchResponse obj = new ViewBranchResponse();
			obj.setId((Integer)row[0]);
			obj.setName((String)row[1]);
			obj.setLandmark((String)row[2]);
			obj.setPincode((Integer)row[3]);
			obj.setAddress((String)row[4]);
			response.add(obj);
			
		}
		return response;
	}



	public void addBranch(String name, String landmark, String pincode, String address) {
		dao.addBranch(name,landmark,pincode,address);
		
	}



	public void deleteBranch(String id) {
		// TODO Auto-generated method stub
		dao.deleteBranch(id);
	}



	public void addUser(String name, String mobile, String password, String address) {
		// TODO Auto-generated method stub
		dao.addUser(name,mobile,password,address);
	}


	public List<ViewUserResponse> viewUser() {
		List<Object[]> result = dao.viewUser();
		List<ViewUserResponse> response = new ArrayList<ViewUserResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			ViewUserResponse obj = new ViewUserResponse();
			obj.setId((Integer)row[0]);
			obj.setName((String)row[1]);
			obj.setMobile((String)row[2]);
			obj.setPassword((String)row[3]);
			obj.setAddress((String)row[4]);
			obj.setFLAG((Integer)row[5]);
			response.add(obj);
			
		}
		return response;
	}



	public void deleteUser(Integer id) {
		dao.deleteUser(id);
		
	}

	
	
}
