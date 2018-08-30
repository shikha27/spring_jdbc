package com.employee.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
//import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.department.dao.DepartmentRepository;
//import com.department.dao.DepartmentRepositoryImpl;
import com.employee.model.*;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private SessionFactory session;
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public void update(Employee employee) {
		session.getCurrentSession().update(employee);
	}

	public Employee getEmployeeById(int id) {
		return (Employee) session.getCurrentSession().get(Employee.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {

		List<Object[]> employeeObjects = session.getCurrentSession().createSQLQuery("select * from employee").list();
		List<Employee> employeeList = new ArrayList<Employee>();

		for (Object[] employeeObject : employeeObjects) {
			Employee employee = convertObjectToEmployee(employeeObject);
			String departmentname = departmentRepository.getDepartmentNameById(employee.getDepartmentid());
			employee.setDepartmentname(departmentname);
			employeeList.add(employee);
		}
		return employeeList;
	}

	private Employee convertObjectToEmployee(Object[] employeeObject) {

		Employee employee = new Employee();
		employee.setId((Integer) employeeObject[0]);
		employee.setName((String) employeeObject[1]);
		employee.setSalary((Double) employeeObject[2]);
		employee.setDepartmentid((Integer) employeeObject[3]);
		return employee;
	}

	// return session.getCurrentSession().createQuery("from Employee").list();

	public void create(Employee employee) {

		session.getCurrentSession().save(employee);

	}

	public void delete(int id) {

		session.getCurrentSession().delete(getEmployeeById(id));

	}

}
