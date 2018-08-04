package com.department.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.department.model.Department;
import com.department.service.DepartmentService;



@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	@Autowired
	DepartmentService departmentService;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView renderAddDepartment() {
		return new ModelAndView("department/department_add");
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("Department") Department department) throws SQLException {
		departmentService.create(department);
		return new ModelAndView("redirect:/department/all");
	}
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView getAllDepartment() throws SQLException {
		List<Department> departments = departmentService.getAllDepartments();
		return new ModelAndView("department/department_view", "multipleDepartments", departments);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView renderEditdepartment(@PathVariable int id) throws SQLException {
	Department department =	departmentService.getDepartmentById(id);
		return new ModelAndView("department/department_update", "singleDepartment", department);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateDepartment(@ModelAttribute("Department") Department department) throws SQLException {
		departmentService.update(department);
		return new ModelAndView("redirect:/department/all");
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) throws SQLException {
		departmentService.delete(id);
		return new ModelAndView("redirect:/department/all");

	}
	
	
}



