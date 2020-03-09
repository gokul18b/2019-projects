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

import com.example.demo.response.ViewCriminalResponse;

@Repository
public class ApiDao {
	@Autowired
	SessionFactory sf;

	public void add_police(String firstname, String lastname, String department, String profession, String username,
			String password, String address) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `police` (`id`, `firstname`, `lastname`, `department`, `profession`, `username`, `password`, `fulladdress`) "
				+ "VALUES (NULL, '" + firstname + "', '" + lastname + "', '" + department + "', '" + profession + "', '"
				+ username + "', '" + password + "', '" + address + "');";
		session.createSQLQuery(sql).executeUpdate();
	}

	public List<Object[]> view_police() {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "Select * from police";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public void add_criminal(String firstname, String lastname, String mobile, String aadhar, String address) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `criminal` (`id`, `firstname`, `lastname`, `mobile`, `aadhar`, `address`) VALUES "
				+ "(NULL, '" + firstname + "', '" + lastname + "', '" + mobile + "', '" + aadhar + "', '" + address
				+ "');";
		session.createSQLQuery(sql).executeUpdate();
	}

	public List<Object[]> view_criminal() {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "Select * from criminal";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public void add_case(String casename, String description) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `caset` (`id`, `casename`, `description`) VALUES " + "(NULL, '" + casename + "', '"
				+ description + "');";
		session.createSQLQuery(sql).executeUpdate();
	}

	public List<Object[]> view_case() {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "Select * from caset";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public List<Object[]> get_criminal(String aadhar) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "Select * from criminal where aadhar='" + aadhar + "'";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public void allocate_case(Integer criminal_id, Integer case_id, String personname, String vehicleno, String mobile,
			String address, String description) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `allocate` (`id`, `criminalid`, `caseid`, `personname`, `vehicleno`, `mobile`, `address`, `description`) VALUES "
				+ "(NULL, '" + criminal_id + "', '" + case_id + "', '" + personname + "', '" + vehicleno + "', '"
				+ mobile + "', '" + address + "', '" + description + "');";
		session.createSQLQuery(sql).executeUpdate();
	}

	public List<Object[]> allocate_history(String aadhar) {
		// TODO Auto-generated method stub

		Session session = sf.getCurrentSession();
		String sql = "SELECT allocate.personname,allocate.vehicleno,allocate.mobile,allocate.description,allocate.datee,caset.casename FROM `allocate` JOIN criminal ON(criminal.id=allocate.criminalid) \r\n"
				+ "		join caset ON(caset.id=allocate.caseid)\r\n" + "		where criminal.aadhar='" + aadhar + "'";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public Integer login(String username, String password) {
		// TODO Auto-generated method stub
		System.out.println("Login");
		Session session = sf.getCurrentSession();
		String sql = "Select * from admin where username='" + username + "' and password='" + password + "'";
		NativeQuery nq = session.createNativeQuery(sql);
		if (nq.list().size() == 0) {
			String sql1 = "Select * from police where username='" + username + "' and password='" + password + "'";
			NativeQuery nq1 = session.createNativeQuery(sql1);
			List<Object[]> a = nq1.list();

			if (nq1.list().size() == 0) {
				return -2;
			} else {
				return (Integer) a.get(0)[0];
			}
		} else {
			return -1;
		}

	}

}
