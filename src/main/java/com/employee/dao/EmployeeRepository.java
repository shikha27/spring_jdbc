package com.employee.dao;


import java.util.List;

import com.employee.model.*;

public interface EmployeeRepository {

	public void update(Employee employee); 
	public void create(Employee employee);

	public List<Employee> getAllEmployees();

	public void delete(int id);
	
	public Employee getEmployeeById(int id);

}
