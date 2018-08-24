package com.employee.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.model.*;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private SessionFactory session;

	public void update(Employee employee) {
		session.getCurrentSession().update(employee);
	}

	public Employee getEmployeeById(int id) {
		return (Employee) session.getCurrentSession().get(Employee.class, id);
	}

	/*
	 * private int getMaxId(){
	 * 
	 * return
	 * 
	 * 
	 * int id=0; String query=
	 * "select max(id) as id from employee order by id desc"; ResultSet rs = null;
	 * 
	 * connection = dataSource.getConnection(); preparedStatement =
	 * connection.prepareStatement(query); rs= preparedStatement.executeQuery();
	 * rs.next(); id= rs.getInt("id"); return id;
	 * 
	 * }
	 */

	public List getAllEmployees() {
		return session.getCurrentSession().createQuery("from Employee").list();
	}

	public void create(Employee employee) {

		session.getCurrentSession().save(employee);

		/*
		 * String query = "insert into employee values(?,?,?,?)";
		 * 
		 * int id = getMaxId(); employee.setId(++id); connection =
		 * dataSource.getConnection(); preparedStatement =
		 * connection.prepareStatement(query); preparedStatement.setInt(1,
		 * employee.getId()); preparedStatement.setString(2, employee.getName());
		 * preparedStatement.setDouble(3, employee.getSalary());
		 * preparedStatement.setInt(4, employee.getDepartmentid()); int out =
		 * preparedStatement.executeUpdate(); if (out != 0) {
		 * System.out.println("Employee saved with id=" + employee.getId()); } else
		 * System.out.println("Employee save failed with id=" + employee.getId());
		 */
	}

	public void delete(int id) {

		session.getCurrentSession().delete(getEmployeeById(id));

		/*
		 * String query = "delete from employee where id=?";
		 * 
		 * connection = dataSource.getConnection(); preparedStatement =
		 * connection.prepareStatement(query); preparedStatement.setInt(1, id); int out
		 * = preparedStatement.executeUpdate(); if (out != 0) {
		 * System.out.println("Employee deleted with id=" + id); } else
		 * System.out.println("No Employee found with id=" + id);
		 */
	}

}
