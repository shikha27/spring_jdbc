package com.department.service;

import java.sql.SQLException;
import java.util.List;

import com.department.model.Department;


public interface DepartmentService {
	public void create(Department department) throws SQLException;
	public List<Department> getAllDepartments() throws SQLException;
	void delete(int id) throws SQLException;

	Department getDepartmentById(int id) throws SQLException;

	void update(Department dept) throws SQLException;

}
