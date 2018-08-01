package com.department.dao;

import java.sql.SQLException;
import java.util.List;

import com.department.model.Department;


public interface DepartmentRepository {
	
	public void create(Department department) throws SQLException;
	public List<Department> getAllDepartments() throws SQLException;

}