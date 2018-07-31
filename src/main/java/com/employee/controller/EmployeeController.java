package com.employee.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.employee.model.Employee;
import com.employee.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView renderAddEmployee() {
		return new ModelAndView("employee_add");
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView create(@ModelAttribute("Employee") Employee employee) {
		employeeService.create(employee);
		return new ModelAndView("redirect:/employee/all");
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ModelAndView getAllEmployee() throws SQLException {
		List<Employee> employees = employeeService.getAllEmployees();
		return new ModelAndView("employee_view", "multipleEmployees", employees);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView renderEditemployee(@PathVariable int id) throws SQLException {
	Employee employee =	employeeService.getEmployeeById(id);
		return new ModelAndView("employee_update", "singleEmployee", employee);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute("Employee") Employee employee) {
		employeeService.update(employee);
		return new ModelAndView("redirect:/employee/all");

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) throws SQLException {
		employeeService.delete(id);
		return new ModelAndView("redirect:/employee/all");

	}

}