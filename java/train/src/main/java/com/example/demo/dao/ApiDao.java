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






}
