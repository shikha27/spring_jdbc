package com.employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.employee.Model.AddModel;

@Controller
public class ViewEmployeeController {

	@Autowired  
    EmpDao dao;
//	
//	 @RequestMapping(value="/ViewEmployee", method = RequestMethod.POST)  
//	    public ModelAndView viewEmployee(){  
//	        List<AddModel> list=dao.getEmployees();  
//	        return new ModelAndView("ViewEmployee","list123",list);  
//	    }  
	
	
}
