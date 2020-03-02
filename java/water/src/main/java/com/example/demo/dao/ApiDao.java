package com.example.demo.dao;

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

	public void add_customer(String name, String mobile, String address, String gender, String email) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `customer` (`id`, `name`, `mobile`, `address`, `gender`, `email`) VALUES (NULL, '"
				+ name + "', '" + mobile + "', '" + address + "', '" + gender + "', '" + email + "');";
		session.createSQLQuery(sql).executeUpdate();
	}

	public void add_purchase(Integer product_id, Integer quantity, Integer price) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `purchase` (`id`, `product_id`, `quantity`, `price`, `date`) VALUES (NULL, '"
				+ product_id + "', '" + quantity + "', '" + price + "', current_timestamp());";
		session.createSQLQuery(sql).executeUpdate();
	}

	public String add_sales(Integer customer_id, Integer product_id, Integer quantity, Integer price) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String previous_sales = "select id,quantity from sales where product_id=" + product_id;
		List<Object[]> previous_salesObj = session.createSQLQuery(previous_sales).list();
		Integer salesed = 0;
		for (int i = 0; i < previous_salesObj.size(); i++) {
			salesed += (Integer) previous_salesObj.get(i)[1];
		}
		System.out.println("Salesed"+salesed);
		String previous_purchase = "select id,quantity from purchase where product_id=" + product_id;
		List<Object[]> previous_purchaseObj = session.createSQLQuery(previous_purchase).list();
		Integer purchased = 0;
		for (int i = 0; i < previous_purchaseObj.size(); i++) {
			purchased += (Integer) previous_purchaseObj.get(i)[1];
		}
		System.out.println("Purchased"+purchased);
		Integer final_quantity = salesed + quantity;
		System.out.println("Final"+final_quantity);
		if (purchased < final_quantity) {
			return "Stock not available";
		} else {
			String sql = "INSERT INTO `sales` (`id`, `customer_id`, `product_id`, `quantity`, `price`) VALUES (NULL, '"
					+ customer_id + "', '" + product_id + "', '" + quantity + "', '" + price + "');";
			session.createSQLQuery(sql).executeUpdate();
			return "Sales sucessfully saved";
		}
	}

	public List<Object[]> get_stock() {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "select \r\n" + "p.companyname,\r\n" + "p.watertype,\r\n" + "p.liter,\r\n"
				+ "COALESCE(sum(pqty),0) - COALESCE(sum(sqty),0) qty from watertype p \r\n"
				+ "LEFT JOIN (select product_id,COALESCE(SUM(quantity),0) pqty from purchase GROUP by product_id) as a on a.product_id = p.id\r\n"
				+ "LEFT JOIN (select product_id,COALESCE(SUM(quantity),0) sqty from sales GROUP by product_id) as b on b.product_id = p.id\r\n"
				+ "GROUP BY p.companyname,p.watertype";
		System.out.println(sql);
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public List<Object[]> get_mobile(String mobile) {
		Session session = sf.getCurrentSession();
		String sql = "Select id,name from customer where mobile='" + mobile + "'";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.getResultList();
	}

	public List<Object[]> get_billing() {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "select customer.name,customer.mobile,watertype.companyname,watertype.watertype,sales.quantity,sales.price from sales LEFT JOIN customer on(customer.id=sales.customer_id) LEFT JOIN watertype on(watertype.id=sales.product_id)";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public Boolean login(String username, String password) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "select * from admin where username='" + username + "' and password='" + password + "'";
		;
		NativeQuery nq = session.createNativeQuery(sql);
		if (nq.list().size() != 0) {
			return true;
		} else {
			return false;
		}
	}

	public void add_water_types(String company, String type, Integer liter, Integer price) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `watertype` (`id`, `companyname`, `watertype`, `liter`, `price`) VALUES (NULL, '"
				+ company + "', '" + type + "', '" + liter + "', '" + price + "');";
		session.createSQLQuery(sql).executeUpdate();
	}

	public List<Object[]> get_water() {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "Select * from watertype";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

}
