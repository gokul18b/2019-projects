package com.example.demo.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.response.LoginResponse;

@Repository
public class ApiDao {
	@Autowired
	SessionFactory sf;

	public void add_passenger(String firstname, String lastname, String mobile, String email, String username,
			String password, String idproof, String address) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `passenger` (`id`, `firstname`, `lastname`, `mobile`, `email`, `username`, `password`, `idproof`, `address`) VALUES"
				+ " (NULL, '"+firstname+"', '"+lastname+"', '"+mobile+"', '"+email+"', '"+username+"', '"+password+"', '"+idproof+"', '"+address+"');";
		session.createSQLQuery(sql).executeUpdate();
	}

	public List<Object[]> get_passenger(String mobile) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "Select * from passenger where mobile='"+mobile+"'";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public void add_train(Integer trainno, String trainname, String from, String to) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `train` (`id`, `trainno`, `trainnname`, `fromlocation`, `tolocation`, `lastlocation`) VALUES (NULL, '"+trainno+"', '"+trainname+"', '"+from+"', '"+to+"', '');";
		session.createSQLQuery(sql).executeUpdate();
	}

	public void location_update(Integer trainid, String location) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "UPDATE `train` SET `lastlocation` = '"+location+"' WHERE `train`.`trainno` = "+trainid+";";
		session.createSQLQuery(sql).executeUpdate();
	}
	
	public List<Object[]> find_location(Integer trainno) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "SELECT * FROM `train` WHERE `trainno`="+trainno;
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public void add_pass(Integer passenger_id, String from, String to,String next, Integer amount) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `ticket` (`id`, `passenger_id`, `fromlocation`, `tolocation`, `nextrenewal`, `amount`) "
				+ "VALUES (NULL, '"+passenger_id+"', '"+from+"', '"+to+"', '"+next+"', '"+amount+"');";
		session.createSQLQuery(sql).executeUpdate();
	}

	public void add_general(Integer passenger_id, String from, String to, Integer amount) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `general` (`id`, `passenger_id`, `fromlocation`, `tolocation`, `amount`) VALUES "
				+ "(NULL, '"+passenger_id+"', '"+from+"', '"+to+"', '"+amount+"');";
		session.createSQLQuery(sql).executeUpdate();
	}

	public List<Object[]> login(String username, String password) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "SELECT id,flag FROM `passenger` WHERE `username`='"+username+"' and password='"+password+"'";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public List<Object[]> get_pass(Integer id) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "SELECT `fromlocation`,`tolocation`,`nextrenewal`,`amount` FROM `ticket` WHERE `passenger_id`="+id;
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public List<Object[]> get_general(Integer id) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "SELECT `fromlocation`,`tolocation`,`amount` FROM `general` WHERE `passenger_id`="+id;
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}






}
