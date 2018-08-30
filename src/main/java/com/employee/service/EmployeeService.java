package com.employee.service;


import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {

	public void create(Employee employee);

	public List<Employee> getAllEmployees();

	public void delete(int id);

	public Employee getEmployeeById(int id);

	public void update(Employee emp);

}
