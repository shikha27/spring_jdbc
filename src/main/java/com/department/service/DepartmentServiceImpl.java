package com.department.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.department.dao.DepartmentRepository;
import com.department.model.Department;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentRepository departmentRepository;

	@Transactional
	public void create(Department department) {
		departmentRepository.create(department);

	}

	@Transactional
	public List getAllDepartments() {

		return departmentRepository.getAllDepartments();
	}

	@Transactional
	public void delete(int id) {
		departmentRepository.delete(id);

	}

	@Transactional
	public Department getDepartmentById(int id) {

		return departmentRepository.getDepartmentById(id);
	}

	@Transactional
	public void update(Department dept) {
		departmentRepository.update(dept);

	}

	@Transactional
	public Map<Integer, String> getDepartmentIdAndName() {

		return departmentRepository.getDepartmentIdAndName();
	}

}
