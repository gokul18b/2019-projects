package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ApiDao;
import com.example.demo.response.GetClassResponse;
import com.example.demo.response.GetDepartmentClassResponse;
import com.example.demo.response.GetDepartmentResponse;
import com.example.demo.response.GetStudentResponse;

@Service
@Transactional
public class ApiService {

	@Autowired
	ApiDao dao;
	
	
//	public List<VoteReportResponse>  votreport() {
//		List<Object[]> result = dao.votreport();
//		List<VoteReportResponse> response = new ArrayList<VoteReportResponse>();
//		for(int i=0;i<result.size();i++) {
//			Object[] row = result.get(i);
//			VoteReportResponse obj = new VoteReportResponse();
//			obj.setUserid((Integer)row[0]);
//			obj.setFirstname((String)row[1]);
//			obj.setCount((BigInteger)row[2]);
//			obj.setPostid((Integer)row[3]);	
//			
//			response.add(obj);
//			
//		}
//		return response;
//	}

	public void student_register(String firstname, String lastname, String mobile, String email, Integer age,
			String gender, String address, Integer ten, Integer twelve, String schoolname, String father, String mother,
			String department, String classname) {
		
		dao.student_register(firstname,lastname,mobile,email,age,gender,address,ten,twelve,schoolname,father,mother,department,classname);
		
	}


	public void add_department(String department, String classname, Integer seat) {
		dao.add_department(department,classname,seat);
		
	}


	public List<GetDepartmentResponse> get_department() {
		List<Object[]> result =dao.get_department();
		
		List<GetDepartmentResponse> response = new ArrayList<GetDepartmentResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			GetDepartmentResponse obj = new GetDepartmentResponse();
			obj.setDepartment_id((Integer)row[0]);
			obj.setDepartment_name((String)row[1]);
			obj.setSeat((Integer)row[2]);	
			
			response.add(obj);
			
		}
		return response;
	
	}


	public List<GetClassResponse> get_class() {
		List<Object[]> result =dao.get_class();
		
		List<GetClassResponse> response = new ArrayList<GetClassResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			GetClassResponse obj = new GetClassResponse();
			obj.setId((Integer)row[0]);
			obj.setDept_allocate_id((Integer)row[1]);
			obj.setClass_name((String)row[2]);	
			
			response.add(obj);
			
		}
		return response;
	}
	
	public List<GetDepartmentClassResponse> get_department_class() {
		List<Object[]> result =dao.get_department_class();
		
		List<GetDepartmentClassResponse> response = new ArrayList<GetDepartmentClassResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			GetDepartmentClassResponse obj = new GetDepartmentClassResponse();
			obj.setDept_id((Integer)row[0]);
			obj.setClass_id((Integer)row[1]);
			
			obj.setDepartmentname((String)row[2]);	
			obj.setClassname((String)row[3]);	
			
			response.add(obj);
			
		}
		return response;
	}
	
	
	public List<GetStudentResponse> show_accepted_student(String department, String classname) {
		List<Object[]> result =dao.show_accepted_student(department,classname);
		
		List<GetStudentResponse> response = new ArrayList<GetStudentResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			GetStudentResponse obj = new GetStudentResponse();
			obj.setId((Integer)row[0]);
			obj.setFirstname((String)row[1]);
			
			obj.setTen((Integer)row[2]);	
			obj.setTwelve((Integer)row[3]);	
			obj.setDepartment((String)row[4]);	
			obj.setClassname((String)row[5]);	
			obj.setMobile((String)row[6]);
			
			response.add(obj);
			
		}
		return response;
	}

	public List<GetStudentResponse> show_pending_student(String department, String classname) {
		List<Object[]> result =dao.show_pending_student(department,classname);
		
		List<GetStudentResponse> response = new ArrayList<GetStudentResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			GetStudentResponse obj = new GetStudentResponse();
			obj.setId((Integer)row[0]);
			obj.setFirstname((String)row[1]);
			
			obj.setTen((Integer)row[2]);	
			obj.setTwelve((Integer)row[3]);	
			obj.setDepartment((String)row[4]);	
			obj.setClassname((String)row[5]);	
			obj.setMobile((String)row[6]);
			
			response.add(obj);
			
		}
		return response;
	}


	public String  approve(Integer id, String department, String classname) {
		return dao.approve(id,department,classname);
		
	}


	public void reject(Integer id) {
		// TODO Auto-generated method stub
		dao.reject(id);
	}


	public Boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return dao.login(username,password);
	}

	
	
}
