package com.employee.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.dao.EmployeeRepository;
import com.employee.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Transactional
	public void create(Employee employee)  {
		employeeRepository.create(employee);
	}

	@Transactional
	public List getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}

	@Transactional
	public void delete(int id){
		employeeRepository.delete(id);
	}

	@Transactional
	public Employee getEmployeeById(int id){
		
		return employeeRepository.getEmployeeById(id);
	}

	@Transactional
	public void update(Employee employee){
		employeeRepository.update(employee);
		
	}

}
