package com.employee.service;

import java.sql.SQLException;
import java.util.List;

import com.employee.model.Employee;

public interface EmployeeService {

	void create(Employee employee);

	List<Employee> getAllEmployees()  throws SQLException;

	void delete(int id);

	Employee getEmployeeById(int id) throws SQLException;

	void update(Employee emp);

}
