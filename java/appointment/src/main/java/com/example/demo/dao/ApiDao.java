package com.example.demo.dao;

import java.math.BigInteger;
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

	public void add_employee(String name, String mobile, String address, String gender, Integer salary, Integer age) {
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `employee` (`id`, `name`, `mobile`, `address`, `gender`, `salary`, `age`) VALUES (NULL, '"
				+ name + "', '" + mobile + "', '" + address + "', '" + gender + "', '" + salary + "', '" + age + "');";
		session.createSQLQuery(sql).executeUpdate();
	}

	public void add_customer(String name, String mobile, String address, String gender, String email) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `customer` (`id`, `name`, `mobile`, `address`, `gender`, `email`) VALUES (NULL, '"
				+ name + "', '" + mobile + "', '" + address + "', '" + gender + "', '" + email + "');";
		session.createSQLQuery(sql).executeUpdate();
	}

	public List<Object[]> get_employee() {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "Select * from employee";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public List<Object[]> get_customer() {
		Session session = sf.getCurrentSession();
		String sql = "Select * from customer";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public void add_product(String company, String model, Integer price) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `product` (`id`, `company`, `model`, `price`) VALUES (NULL, '" + company + "', '"
				+ model + "', '" + price + "');";
		session.createSQLQuery(sql).executeUpdate();
	}

	public List<Object[]> get_product() {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "Select * from product";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public void add_purchase(Integer product_id, Integer quantity) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `purchase` (`id`, `product_id`, `quantity`, `date`) VALUES (NULL, '" + product_id
				+ "', '" + quantity + "', current_timestamp());";
		session.createSQLQuery(sql).executeUpdate();
	}

	public void add_sales(Integer customer_id, Integer product_id, Integer quantity) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `sales` (`id`, `customer_id`, `product_id`, `quantity`) VALUES (NULL, '" + customer_id
				+ "', '" + product_id + "', '" + quantity + "');";
		session.createSQLQuery(sql).executeUpdate();
	}

	public List<Object[]> get_stock() {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "select p.company,p.model,COALESCE(sum(pqty),0) - COALESCE(sum(sqty),0) qty from product p \r\n"
				+ "LEFT JOIN (select product_id,COALESCE(SUM(quantity),0) pqty from purchase GROUP by product_id) as a on a.product_id = p.id\r\n"
				+ "LEFT JOIN (select product_id,COALESCE(SUM(quantity),0) sqty from sales GROUP by product_id) as b on b.product_id = p.id\r\n"
				+ "GROUP BY p.company,p.model";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public Integer get_mobile(String mobile) {
		Session session = sf.getCurrentSession();
		String sql = "Select id,name from customer where mobile='" + mobile + "'";
		NativeQuery nq = session.createNativeQuery(sql);
		List<Object[]> list = nq.getResultList();
		if (list.size() != 0) {
			return (Integer) list.get(0)[0];
		} else {
			return null;
		}

	}

	public List<Object[]> get_billing() {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "select customer.name,customer.mobile,product.company,product.model,sales.quantity,product.price from sales LEFT JOIN customer on(customer.id=sales.customer_id) LEFT JOIN product on(product.id=sales.product_id) ";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	

	public void add_patient(String firstname, String lastname, String mobile, String email, String attendar,
			String emergency) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `patient` (`id`, `firstname`, `lastname`, `mobile`, `email`, `attendar`, `emergency`) "
				+ "VALUES (NULL, '"+firstname+"', '"+lastname+"', '"+mobile+"', '"+email+"', '"+attendar+"', '"+emergency+"');";
			
		session.createSQLQuery(sql).executeUpdate();
	}

	public Object[] get_patient(String mobile) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "Select id,firstname,lastname from patient where mobile='" + mobile + "'";
		NativeQuery nq = session.createNativeQuery(sql);
		List<Object[]> list = nq.getResultList();
		if (list.size() != 0) {
			return list.get(0);
		} else {
			return null;
		}
	}

	public void book_appointment(Integer doctor_id, Integer patient_id, Integer amount, String appointment_date) {
		// TODO Auto-generated method stub
		
		Session session = sf.getCurrentSession();
		
		String q1 = "SELECT * FROM `appointment` WHERE `doctor_id`="+doctor_id+" and `appointment_date`='"+appointment_date+"' ";
		NativeQuery nqa = session.createNativeQuery(q1);
		Integer token =  nqa.list().size()+1;
		
		
		String sql = "INSERT INTO `appointment` (`id`, `doctor_id`, `patient_id`, `amount`, `appointment_date`,`token`) VALUES (NULL, '"+doctor_id+"', '"+patient_id+"', '"+amount+"', '"+appointment_date+"','"+token+"');";			
		session.createSQLQuery(sql).executeUpdate();
	}

	public void adddoctor(String doctorname, String qualification, String speciality, String username,
			String password) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `doctor` (`id`, `doctorname`, `speciality`, `qualification`, `username`, `password`) "
				+ "VALUES (NULL, '"+doctorname+"', '"+qualification+"', '"+speciality+"', '"+username+"', '"+password+"');";
			
		session.createSQLQuery(sql).executeUpdate();
	}

	public List<Object[]> get_doctorlist() {
		Session session = sf.getCurrentSession();
		String sql = "select id,doctorname,speciality from doctor";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}
	
	public List<Object[]> login(String username, String password) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "select * from doctor where username='"+username+"' and password='"+password+"'";;
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public List<Object[]> get_appointment_details_doctor(Integer id, String date) {
		// TODO Auto-generated method stub
		
		Session session = sf.getCurrentSession();
		String sql = "select p.firstname,p.lastname,p.mobile,a.appointment_date,a.token from patient p right join appointment a ON(p.id=a.patient_id)\r\n" + 
				"		where a.doctor_id="+id+" and a.appointment_date='"+date+" ' order by a.token";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
		
	}

}
