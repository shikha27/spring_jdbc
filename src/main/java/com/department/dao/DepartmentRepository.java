package com.department.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.department.model.Department;



public interface DepartmentRepository {
	
	public void create(Department department) throws SQLException;
	public List<Department> getAllDepartments() throws SQLException;
    public void update(Department department) throws SQLException;
    public void delete(int id) throws SQLException;
    public Department getDepartmentById(int id) throws SQLException;
    public Map<Integer, String> getDepartmentIdAndName() throws SQLException;
}
