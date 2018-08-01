package com.department.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.department.dao.DepartmentRepository;
import com.department.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
@Autowired
	DepartmentRepository departmentRepository;

	public void create(Department department) throws SQLException {
		departmentRepository.create(department);
		
	}

	public List<Department> getAllDepartments() throws SQLException {
		
		return departmentRepository.getAllDepartments();
	}
	

}
