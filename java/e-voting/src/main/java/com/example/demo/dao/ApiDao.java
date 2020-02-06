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

	public List<Object[]> getprofile(Integer id) {
		Session session = sf.getCurrentSession();
		String sql = "select userid,usertype,email,password,firstname,lastname,mobilenumber,address  from user where userid="+id;
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

	public void addVoter(String firstname, String lastname, String mobile, String email, String address) {
		
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `ovs`.`user` (`userid`, `usertype`, `email`, `password`, `firstname`, `lastname`, `mobilenumber`, `address`) VALUES (NULL, '0', '"+email+"', '123', '"+firstname+"', '"+lastname+"', '"+mobile+"', '"+address+"');";
		NativeQuery a = session.createSQLQuery(sql);
		a.executeUpdate();	
	}

	public void deleteVoter(Integer id) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "delete from user where userid="+id;
		NativeQuery a = session.createSQLQuery(sql);
		a.executeUpdate();	
	}

	public List<Object[]> viewVoter() {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "SELECT userid, usertype, email, password, firstname, lastname, mobilenumber, address FROM user where usertype!=1 order by firstname";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public void addCandidate(String firstname, String lastname, String mobile, String email, String address,
			String post) {
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `ovs`.`candidates` (`userid`, `post`, `firstname`, `lastname`, `mobile`, `email`, `address`, `img`) VALUES (NULL, '"+post+"', '"+firstname+"', '"+lastname+"', '"+mobile+"', '"+email+"', '"+address+"', '');";
		NativeQuery a = session.createSQLQuery(sql);
		a.executeUpdate();	
		
	}

	public void deleteCandidates(Integer id) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "delete from candidates where userid="+id;
		NativeQuery a = session.createSQLQuery(sql);
		a.executeUpdate();	
	}

	public List<Object[]> viewCandidates() {
		Session session = sf.getCurrentSession();
		String sql = "SELECT userid, post, firstname, lastname, mobile, address,email FROM candidates order by firstname";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public List<Object[]> login(String username, String password) {
		Session session = sf.getCurrentSession();
		String sql = "SELECT userid,usertype,email,password,firstname,lastname,mobilenumber,address FROM user where email='"+username+"' and password='"+password+"'";;
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public void pullvote(String canid, String votid, String postid) {
		// TODO Auto-generated method stub
		
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `ovs`.`voting` (`id`, `canid`, `votid`, `postid`) VALUES (NULL, '"+canid+"', '"+votid+"', '"+postid+"');";
		NativeQuery a = session.createSQLQuery(sql);
		a.executeUpdate();	
	}

	public List<Object[]> validateVoting(String id) {
		Session session = sf.getCurrentSession();
		String sql = "select id,canid,votid,postid from voting where votid="+id;
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public List<Object[]> votreport() {
		Session session = sf.getCurrentSession();
		String sql = "select c.userid,c.firstname,count(v.id) as count,c.post as postid from candidates as c left join voting as v on (v.canid=c.userid) group by c.userid,c.firstname order by count desc";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}
	
	

}
