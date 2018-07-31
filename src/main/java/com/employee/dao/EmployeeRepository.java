package com.employee.dao;

import java.sql.SQLException;
import java.util.List;

import com.employee.model.*;

public interface EmployeeRepository {

	public void update(Employee employee) throws SQLException;

	public void create(Employee employee) throws SQLException;

	public List<Employee> getAllEmployees() throws SQLException;

	public void delete(int id) throws SQLException;
	
	public Employee getEmployeeById(int id) throws SQLException;

}
