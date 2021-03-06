package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ApiDao;
import com.example.demo.response.FindLocationResponse;
import com.example.demo.response.GetGeneralResponse;
import com.example.demo.response.GetPassResponse;
import com.example.demo.response.GetPassengerResponse;
import com.example.demo.response.LoginResponse;

@Service
@Transactional
public class ApiService {

	@Autowired
	ApiDao dao;

	public void add_passenger(String firstname, String lastname, String mobile, String email, String username,
			String password, String idproof, String address) {
		// TODO Auto-generated method stub
		dao.add_passenger(firstname, lastname, mobile, email, username, password, idproof, address);

	}

	public List<GetPassengerResponse> get_passenger(String mobile) {
		// TODO Auto-generated method stub
		List<Object[]> result = dao.get_passenger(mobile);

		List<GetPassengerResponse> response = new ArrayList<GetPassengerResponse>();
		for (int i = 0; i < result.size(); i++) {
			Object[] row = result.get(i);
			GetPassengerResponse obj = new GetPassengerResponse();

			obj.setId((Integer) row[0]);
			obj.setFirstname((String) row[1]);
			obj.setLastname((String) row[2]);
			obj.setMobile((String) row[3]);
			obj.setEmail((String) row[4]);
			obj.setUsername((String) row[5]);
			obj.setPassword((String) row[6]);
			obj.setIdproof((String) row[7]);
			obj.setAddress((String) row[8]);
			response.add(obj);

		}
		return response;
	}

	public void add_train(Integer trainno, String trainname, String from, String to) {
		// TODO Auto-generated method stub
		dao.add_train(trainno, trainname, from, to);
	}

	public void location_update(Integer trainid, String location) {
		// TODO Auto-generated method stub
		dao.location_update(trainid, location);
	}

	public List<FindLocationResponse> find_location(Integer trainno) {
		// TODO Auto-generated method stub
		List<Object[]> result = dao.find_location(trainno);

		List<FindLocationResponse> response = new ArrayList<FindLocationResponse>();
		for (int i = 0; i < result.size(); i++) {
			Object[] row = result.get(i);
			FindLocationResponse obj = new FindLocationResponse();

			obj.setTrainname((String) row[2]);
			obj.setFrom((String) row[3]);
			obj.setTo((String) row[4]);
			obj.setLastlocation((String) row[5]);

			response.add(obj);
		}
		return response;
	}

	public void add_pass(Integer passenger_id, String from, String to, String next, Integer amount) {
		// TODO Auto-generated method stub
		dao.add_pass(passenger_id, from, to, next, amount);
	}

	public void add_general(Integer passenger_id, String from, String to, Integer amount) {
		// TODO Auto-generated method stub
		dao.add_general(passenger_id, from, to, amount);
	}

	public LoginResponse login(String username, String password) {
		// TODO Auto-generated method stub
		List<Object[]> result = dao.login(username, password);

		if (result.size() != 0) {
			Object[] row = result.get(0);
			LoginResponse obj = new LoginResponse();

			obj.setId((Integer) row[0]);
			obj.setFLAG((String) row[1]);

			return obj;
		}else {
			return null;
		}
	}

	public List<GetPassResponse> get_pass(Integer id) {
		// TODO Auto-generated method stub
		List<Object[]> result = dao.get_pass(id);

		List<GetPassResponse> response = new ArrayList<GetPassResponse>();
		for (int i = 0; i < result.size(); i++) {
			Object[] row = result.get(i);
			GetPassResponse obj = new GetPassResponse();

			obj.setFromLocation((String) row[0]);
			obj.setToLocation((String) row[1]);
			obj.setNextRenewal((String) row[2]);
			obj.setAmount((Integer) row[3]);

			response.add(obj);
		}
		return response;
	}

	public List<GetGeneralResponse> get_general(Integer id) {
		// TODO Auto-generated method stub
		List<Object[]> result = dao.get_general(id);

		List<GetGeneralResponse> response = new ArrayList<GetGeneralResponse>();
		for (int i = 0; i < result.size(); i++) {
			Object[] row = result.get(i);
			GetGeneralResponse obj = new GetGeneralResponse();

			obj.setFromLocation((String) row[0]);
			obj.setToLocation((String) row[1]);
			obj.setAmount((Integer) row[2]);

			response.add(obj);
		}
		return response;
	}

}
