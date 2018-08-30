package com.department.dao;


import java.util.List;
import java.util.Map;

import com.department.model.Department;



public interface DepartmentRepository {
	
	public void create(Department department);
	public List getAllDepartments();
    public void update(Department department);
    public void delete(int id);
    public Department getDepartmentById(int id);
    public Map<Integer, String> getDepartmentIdAndName();
	public String getDepartmentNameById(int departmentid);
}
