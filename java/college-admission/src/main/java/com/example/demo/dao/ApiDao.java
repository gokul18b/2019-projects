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

	public void student_register(String firstname, String lastname, String mobile, String email, Integer age,
			String gender, String address, Integer ten, Integer twelve, String schoolname, String father, String mother,
			String department, String classname) {
		Session session = sf.getCurrentSession();
		String sql = "INSERT INTO `student` (`id`, `firstname`, `lastname`, `mobile`, `email`, `age`, `gender`, `address`, `department`, `classname`, `10th`, `12th`, `schoolname`, `fathername`, `mothername`) "
				+ "VALUES (NULL, '" + firstname + "', '" + lastname + "', '" + mobile + "', '" + email + "', '" + age
				+ "', '" + gender + "', '" + address + "', '" + department + "', '" + classname + "', '" + ten + "', '"
				+ twelve + "', '" + schoolname + "', '" + father + "', '" + mother + "');";
		NativeQuery a = session.createSQLQuery(sql);
		a.executeUpdate();

	}

	public void add_department(String department, String classname, Integer seat) {

		Session session = sf.getCurrentSession();
		String sql = "Select id from department where department_name='" + department + "'";
		NativeQuery nq = session.createNativeQuery(sql);
		List<Object[]> row = nq.list();

		if (row.size() == 0) {
			String sql1 = "INSERT INTO `department` (`department_name`, `seat_count`, `id`) VALUES ('" + department
					+ "', '" + seat + "', NULL);";
			session.createSQLQuery(sql1).executeUpdate();
			 
			List<Object[]> b = session.createNativeQuery(sql).list();
			System.out.println("Department "+b.get(0));
			
			String sql2 = "INSERT INTO `class_allocate` (`id`, `dept_allocate_id`, `class_name`) VALUES (NULL, '"
					+ b.get(0) + "', '" + classname + "');";
			NativeQuery ab = session.createSQLQuery(sql2);
			ab.executeUpdate();
		} else {
			// System.out.println(row.get(index));
			// dept_id = (Integer)row.get(0);

			String sql2 = "INSERT INTO `class_allocate` (`id`, `dept_allocate_id`, `class_name`) VALUES (NULL, '"
					+ row.get(0) + "', '" + classname + "');";
			NativeQuery ab = session.createSQLQuery(sql2);
			ab.executeUpdate();
		}

	}

	public List<Object[]> get_department() {
		Session session = sf.getCurrentSession();
		String sql = "Select id,department_name,seat_count from department";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public List<Object[]> get_class() {
		Session session = sf.getCurrentSession();
		String sql = "Select id,dept_allocate_id,class_name from class_allocate";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public List<Object[]> get_department_class() {
		Session session = sf.getCurrentSession();
		String sql = "select dept.id as deptid,cls.id as classid,dept.department_name,cls.class_name,concat(dept.department_name,' ',cls.class_name) as classname from department dept JOIN class_allocate cls ON(cls.dept_allocate_id=dept.id) GROUP BY concat(dept.department_name,' ',cls.class_name)";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public List<Object[]> show_pending_student(String department, String classname) {
		Session session = sf.getCurrentSession();
		String sql = "SELECT `id`, `firstname`, `10th`, `12th`,`department`,`classname`,`mobile` FROM `student` where confirmation=0 and department='"
				+ department + "' and classname='" + classname + "'";
		NativeQuery nq = session.createNativeQuery(sql);
		return nq.list();
	}

	public String approve(Integer id, String department, String classname) {
		Session session = sf.getCurrentSession();

		String sql = "SELECT `id`, `firstname`, `10th`, `12th`,`department`,`classname` FROM `student` where confirmation=0 and department='"
				+ department + "' and classname='" + classname + "'";
		NativeQuery nq = session.createNativeQuery(sql);
		nq.list();

		String sql1 = "select seat_count,id from department where department_name='"+department+"'";
		List<Object[]> rowList = session.createNativeQuery(sql1).list();
		System.out.println(rowList.get(0)[0]);
		//Integer seat_count = (Integer)rowList.get(0)[0];
		
		String sql4 = "select count(*),id from allocate where dept_allocate_id='"+department+"'";
		List<Object[]> rowList1 = session.createNativeQuery(sql4).list();
		System.out.println("test"+rowList1.get(0)[0]);
		BigInteger allocate_count = (BigInteger)rowList1.get(0)[0];
		
		System.out.println((Integer) rowList.get(0)[0]+">="+allocate_count.intValue());
		
		if ((Integer) rowList.get(0)[0]> allocate_count.intValue()) {
			String update = "Update `student` set confirmation=1 where id=" + id;
			session.createSQLQuery(update).executeUpdate();

			String sql2 = "INSERT INTO `allocate` (`id`, `dept_allocate_id`, `class_allocate_id`, `student_id`, `confirmation`) VALUES (NULL, '"
					+ department + "', '" + classname + "', '" + id + "', '1');";
			session.createSQLQuery(sql2).executeUpdate();
			return "Student Has Allocated";
		}else {
			return "This department seat already completed";
		}

	}

	public void reject(Integer id) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "delete from student where id=" + id;
		NativeQuery a = session.createSQLQuery(sql);
		a.executeUpdate();
	}

	public Boolean login(String username, String password) {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		String sql = "select * from admin where username='"+username+"' and password='"+password+"'";;
		NativeQuery nq = session.createNativeQuery(sql);
		if (nq.list().size() != 0) {
			return true;
		} else {
			return false;
		}
	}

}
