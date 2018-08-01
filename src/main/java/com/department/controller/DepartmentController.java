package com.department.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		return new ModelAndView("redirect:department/all");
	}
	
	
	@RequestMapping(value = "department/all", method = RequestMethod.GET)
	public ModelAndView getAllDepartment() throws SQLException {
		List<Department> departments = departmentService.getAllDepartments();
		return new ModelAndView("department/department_view", "multipleDepartments", departments);
	}
}
