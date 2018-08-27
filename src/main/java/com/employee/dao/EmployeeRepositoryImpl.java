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

	

	public List getAllEmployees() {
		return session.getCurrentSession().createQuery("from Employee").list();
	}

	public void create(Employee employee) {

		session.getCurrentSession().save(employee);

	}

	public void delete(int id) {

		session.getCurrentSession().delete(getEmployeeById(id));

		
	}

}
