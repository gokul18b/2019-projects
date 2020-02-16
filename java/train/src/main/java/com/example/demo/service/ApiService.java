package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ApiDao;
import com.example.demo.response.GetPassengerResponse;

@Service
@Transactional
public class ApiService {

	@Autowired
	ApiDao dao;

	
	public void add_passenger(String firstname, String lastname, String mobile, String email, String username,
			String password, String idproof, String address) {
		// TODO Auto-generated method stub
		dao.add_passenger(firstname,lastname,mobile,email,username,password
				,idproof,address);
		
	}


	public List<GetPassengerResponse> get_passenger(String mobile) {
		// TODO Auto-generated method stub
		List<Object[]> result =dao.get_passenger(mobile);
		
		List<GetPassengerResponse> response = new ArrayList<GetPassengerResponse>();
		for(int i=0;i<result.size();i++) {
			Object[] row = result.get(i);
			GetPassengerResponse obj = new GetPassengerResponse();
			
			obj.setId((Integer)row[0]);
			obj.setFirstname((String)row[1]);
			obj.setLastname((String)row[2]);
			obj.setMobile((String)row[3]);
			obj.setEmail((String)row[4]);
			obj.setUsername((String)row[5]);
			obj.setPassword((String)row[6]);
			obj.setIdproof((String)row[7]);
			obj.setAddress((String)row[8]);
			response.add(obj);
			
		}
		return response;
	}

	
	




	
	
}
