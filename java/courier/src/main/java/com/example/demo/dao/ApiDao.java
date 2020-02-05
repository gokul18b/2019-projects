package com.example.demo.dao;

import java.math.BigInteger;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.request.AddCourierRequest;
import com.example.demo.request.AddCustomerRequest;
import com.example.demo.request.LoginRequest;
import com.example.demo.request.SearchRequest;
import com.example.demo.request.UpdateCourierRequest;

@Repository
public class ApiDao {
	@Autowired
	SessionFactory sf;

	public List<Object[]> viewCustomer() {
		Session session = sf.getCurrentSession();
		String sql = "Select name,mobile,address from customer";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public List<BigInteger> login(LoginRequest body) {
		Session session = sf.getCurrentSession();
		String sql = "select count(*) as count from admin where username='"+body.getUsername()+"' and password='"+body.getPassword()+"'";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public void addCustomer(AddCustomerRequest body) {
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `customer` ( `name`, `mobile`, `address`) VALUES ( '" + body.getName() + "', '" + body.getMobile() + "', '" + body.getAddress() + "');";
		session.createSQLQuery(sql).executeUpdate();
		
		
	}

	public void addCourier(AddCourierRequest body) {
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `courier` (`id`, `mobile`, `name`, `sendlocation`, `currentlocation`, `address`) VALUES (NULL, '"+body.getMobile()+"', '"+body.getName()+"', '"+body.getSendlocation()+"', '', '"+body.getFulladdress()+"');";
		NativeQuery a = session.createSQLQuery(sql);
		a.executeUpdate();	
	}

	public void updateCourier(UpdateCourierRequest body) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "UPDATE `courier` SET `currentlocation` = '"+body.getCurrentlocation()+"' WHERE `courier`.`id` = "+body.getCourierno()+";";
		NativeQuery a = session.createSQLQuery(sql);
		a.executeUpdate();
	}

	public List<Object[]> search(SearchRequest body) {
		Session session = sf.getCurrentSession();
		String sql = "Select * from courier where id="+body.getCourierno();
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public List<Object[]> viewCourier() {
		Session session = sf.getCurrentSession();
		String sql = "Select * from courier ";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}
	
	

}
