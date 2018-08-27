package com.department.service;


import java.util.List;
import java.util.Map;

import com.department.model.Department;


public interface DepartmentService {
	public void create(Department department);
	public List getAllDepartments();
	void delete(int id);

	public Department getDepartmentById(int id);

	void update(Department dept) ;
	
	public Map<Integer, String> getDepartmentIdAndName();

}
