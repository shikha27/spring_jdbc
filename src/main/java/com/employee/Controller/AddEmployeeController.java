package com.employee.Controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.employee.Model.AddModel;

@Controller
public class AddEmployeeController {
	@Autowired  
	EmployeeDAOImpl dao;
	
	@RequestMapping(value="/addModel", method=RequestMethod.GET)
	public ModelAndView registerdata(){
		
		return new ModelAndView("addmodel","command", new AddModel());
	}
	
	
	@RequestMapping(value = "/AddEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployee(){
	//	dao.save(emp);
		return new ModelAndView("AddEmployee");
		
	}
	
	
	//add n save
	@RequestMapping(value = "/AddEmployee", method = RequestMethod.POST)
	public ModelAndView adEmployee(@ModelAttribute("addmodel")AddModel emp){
		dao.save(emp);
		return new ModelAndView("redirect:/ViewEmployee");
		
	}
	
	
	//viewall
	 @RequestMapping(value="/ViewEmployee")  
	    public ModelAndView viewEmployee() throws SQLException{  
	        List<AddModel> list=dao.getAll();  
	        return new ModelAndView("ViewEmployee","list123",list);  
	    }  
	 
	 
	 //edit rendering to edit jsp
	 
	 
	 
	 
	 @RequestMapping(value = "/Update/{id}", method = RequestMethod.GET)
	 public ModelAndView editemployee(@PathVariable int id) throws SQLException {
		 dao.getById(id);
		 return new ModelAndView("Update");
		 
	 }
	 
	 
	 
	 //update
	 @RequestMapping(value= "/Update", method = RequestMethod.POST)
	 public ModelAndView updateEmployee(@ModelAttribute("addmodel")AddModel emp) {
		 dao.update(emp);
		 return new ModelAndView("redirect:/ViewEmployee");
		 
	 }
	 
	 //delete by id
	 
	 @RequestMapping(value = "/deleteemp/{id}", method= RequestMethod.GET)
	public ModelAndView deleteemployee(@PathVariable int id) throws SQLException {
		 dao.deleteById(id);
		 return new ModelAndView("redirect:/ViewEmployee");
		 
	 }
	
	
	
	
	
	
	
	
	/* public String adEmployee(@ModelAttribute("AddModel")AddModel emp, 
	   ModelMap model) {
	      model.addAttribute("id", emp.getId());
	      model.addAttribute("name", emp.getName());
	      model.addAttribute("salary", emp.getSalary());
	      model.addAttribute("department", emp.getDepartment());
	      System.out.println(model);
	      return "ViewEmployee";
	   }*/
}
