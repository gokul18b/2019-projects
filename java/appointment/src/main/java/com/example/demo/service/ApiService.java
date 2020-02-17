package com.example.demo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ApiDao;
import com.example.demo.response.GetAppointmentDetailsResponse;
import com.example.demo.response.GetBillingResponse;
import com.example.demo.response.GetCustomerResponse;
import com.example.demo.response.GetDoctorListResponse;
import com.example.demo.response.GetEmployeeResponse;
import com.example.demo.response.GetPatientResponse;
import com.example.demo.response.GetProductResponse;
import com.example.demo.response.GetStockResponse;

@Service
@Transactional
public class ApiService {

	@Autowired
	ApiDao dao;

	public void add_employee(String name, String mobile, String address, String gender, Integer salary, Integer age) {
		dao.add_employee(name,mobile,address,gender,salary,age);
		
	}

	public void add_customer(String name, String mobile, String address, String gender, String email) {
		// TODO Auto-generated method stub
		dao.add_customer(name,mobile,address,gender,email);
		
	}

	public List<GetEmployeeResponse> get_employee() {
		// TODO Auto-generated method stub
		List<Object[]> result =dao.get_employee();
		
		List<GetEmployeeResponse> response = new ArrayList<GetEmployeeResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			GetEmployeeResponse obj = new GetEmployeeResponse();
			obj.setId((Integer)row[0]);
			obj.setName((String)row[1]);
			obj.setMobile((String)row[2]);
			obj.setAddress((String)row[3]);
			obj.setGender((String)row[4]);
			obj.setSalary((Integer)row[5]);
			obj.setAge((Integer)row[6]);
			
			response.add(obj);
			
		}
		return response;
		
	}

	public List<GetCustomerResponse> get_customer() {
		// TODO Auto-generated method stub
		List<Object[]> result =dao.get_customer();
		
		List<GetCustomerResponse> response = new ArrayList<GetCustomerResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			GetCustomerResponse obj = new GetCustomerResponse();
			obj.setId((Integer)row[0]);
			obj.setName((String)row[1]);
			obj.setMobile((String)row[2]);
			obj.setAddress((String)row[3]);
			obj.setGender((String)row[4]);
			obj.setEmail((String)row[5]);
			
			
			response.add(obj);
			
		}
		return response;
		
	}

	public void add_product(String company, String model, Integer price) {
		// TODO Auto-generated method stub
		dao.add_product(company,model,price);
	}

	public List<GetProductResponse> get_product() {
		// TODO Auto-generated method stub
		
		List<Object[]> result =dao.get_product();
		
		List<GetProductResponse> response = new ArrayList<GetProductResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			GetProductResponse obj = new GetProductResponse();
			obj.setId((Integer)row[0]);
			obj.setCompany((String)row[1]);
			obj.setModel((String)row[2]);
			obj.setPrice((Integer)row[3]);
			
			
			
			response.add(obj);
			
		}
		return response;
	}

	public void add_purchase(Integer product_id, Integer quantity) {
		// TODO Auto-generated method stub
		dao.add_purchase(product_id,quantity);
	}

	public void add_sales(Integer customer_id, Integer product_id, Integer quantity) {
		// TODO Auto-generated method stub
		dao.add_sales(customer_id,product_id,quantity);
	}

	public List<GetStockResponse> get_stock() {
		List<Object[]> result =dao.get_stock();
		
		List<GetStockResponse> response = new ArrayList<GetStockResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			GetStockResponse obj = new GetStockResponse();
			obj.setCompany_name((String)row[0]+"-"+(String)row[1]);
			obj.setQuantity((BigDecimal)row[2]);
			
			response.add(obj);
			
		}
		return response;
	}

	public Integer get_mobile(String mobile) {
		// TODO Auto-generated method stub
		return dao.get_mobile(mobile);
	}

	

	public List<GetBillingResponse> get_billing() {
		List<Object[]> result =dao.get_billing();
		
		List<GetBillingResponse> response = new ArrayList<GetBillingResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			GetBillingResponse obj = new GetBillingResponse();
			obj.setCustomer_name((String)row[0]);
			obj.setMobile((String)row[1]);
			obj.setCompany((String)row[2]);
			obj.setModel((String)row[3]);
			obj.setQuantity((Integer)row[4]);
			obj.setPrice((Integer)row[5]);
			
			response.add(obj);
			
		}
		return response;
	}

	public List<Object[]> login(String username, String password) {
		
		return dao.login(username,password);
	}

	public void add_patient(String firstname, String lastname, String mobile, String email, String attendar,
			String emergency) {
		dao.add_patient(firstname,lastname,mobile,email,attendar,emergency);
		
	}

	public GetPatientResponse get_patient(String mobile) {
		// TODO Auto-generated method stub
		Object[] obj= dao.get_patient(mobile);
		GetPatientResponse res = new GetPatientResponse();
		res.setFirstname((String)obj[1]);
		res.setId((Integer)obj[0]);
		res.setLastname((String)obj[2]);
		return res;
	}

	public void book_appointment(Integer doctor_id, Integer patient_id, Integer amount, String appointment_date) {
		dao.book_appointment(doctor_id,patient_id,amount,appointment_date);
		
	}

	public void adddoctor(String doctorname, String qualification, String speciality, String username,
			String password) {
		// TODO Auto-generated method stub
		dao.adddoctor(doctorname,qualification,speciality,username,password);
		
	}

	public List<GetDoctorListResponse> get_doctorlist() {
		List<Object[]> result =dao.get_doctorlist();
		
		List<GetDoctorListResponse> response = new ArrayList<GetDoctorListResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			GetDoctorListResponse obj = new GetDoctorListResponse();
			obj.setId((Integer)row[0]);
			obj.setName((String)row[1]);
			obj.setSpeciality((String)row[2]);
			
			response.add(obj);
			
		}
		return response;
	}

	public List<GetAppointmentDetailsResponse> get_appointment_details_doctor(Integer id, String date) {
		// TODO Auto-generated method stub
			List<Object[]> result =dao.get_appointment_details_doctor(id,date);
		
		List<GetAppointmentDetailsResponse> response = new ArrayList<GetAppointmentDetailsResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			GetAppointmentDetailsResponse obj = new GetAppointmentDetailsResponse();
			obj.setFirstname((String)row[0]);
			obj.setLastname((String)row[1]);
			obj.setMobile((String)row[2]);
			obj.setTokenno((Integer)row[4]);
			obj.setAppointmentdate((String)row[3]);
			
			response.add(obj);
			
		}
		return response;
	}
	
	
	
}
