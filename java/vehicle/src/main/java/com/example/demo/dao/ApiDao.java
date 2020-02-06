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

	
	public List<Object[]> login(String mobile, String password) {
		Session session = sf.getCurrentSession();
		String sql = "select id,name,mobile,password,address,FLAG from user where mobile='"+mobile+"' and password='"+password+"'";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}
	
	
	





	public List<Object[]> viewBranch() {
		Session session = sf.getCurrentSession();
		String sql = "select id,name,landmark,pincode,address from branch order by id desc";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}




	public void addBranch(String name, String landmark, String pincode, String address) {
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `vehicleservice`.`branch` (`id`, `name`, `landmark`, `pincode`, `address`) VALUES (NULL, '"+name+"', '"+landmark+"', '"+pincode+"', '"+address+"');";
		NativeQuery a = session.createSQLQuery(sql);
		a.executeUpdate();	
		
	}

	public void deleteBranch(String id) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "delete from branch where id="+id;
		NativeQuery a = session.createSQLQuery(sql);
		a.executeUpdate();	
	}
	public void addUser(String name, String mobile, String password, String address) {
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `vehicleservice`.`user` (`id`, `name`, `mobile`, `password`, `address`,`FLAG`) VALUES (NULL, '"+name+"', '"+mobile+"', '"+password+"', '"+address+"',0);";
		NativeQuery a = session.createSQLQuery(sql);
		a.executeUpdate();	
		
	}
	public List<Object[]> viewUser() {
		Session session = sf.getCurrentSession();
		String sql = "select id,name,mobile,password,address,FLAG from user where FLAG!=1 order by id desc";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "delete from user where id="+id;
		NativeQuery a = session.createSQLQuery(sql);
		a.executeUpdate();	
	}
	
	

}
