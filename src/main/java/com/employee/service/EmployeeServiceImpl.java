package com.employee.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeRepository;
import com.employee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public void create(Employee employee) {
		employeeRepository.create(employee);
	}

	public List<Employee> getAllEmployees() throws SQLException {
		return employeeRepository.getAllEmployees();
	}

	public void delete(int id) {
		employeeRepository.delete(id);
	}

	public Employee getEmployeeById(int id) throws SQLException {
		
		return employeeRepository.getEmployeeById(id);
	}

	public void update(Employee employee) {
		employeeRepository.update(employee);
		
	}

}
