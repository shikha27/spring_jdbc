package com.employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.employee.Model.AddModel;

@Controller
public class AddEmployeeController {
	@Autowired  
    EmpDao dao;
	@RequestMapping(value="/addModel", method=RequestMethod.GET)
	public ModelAndView registerdata(){
		
		return new ModelAndView("addmodel","command", new AddModel());
	}
	
	@RequestMapping(value = "/adEmployee", method = RequestMethod.POST)
	public ModelAndView ademployee(@ModelAttribute("addmodel") AddModel emp){
		dao.save(emp);
		return new ModelAndView("rediect:/ViewEmployee");
		
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
