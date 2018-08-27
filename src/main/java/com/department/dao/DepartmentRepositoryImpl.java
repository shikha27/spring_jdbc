package com.department.dao;



import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.department.model.Department;


@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository{

	
	@Autowired
	private SessionFactory sessionFactory;

	

	public Map<Integer, String> getDepartmentIdAndName(){
		Map<Integer,String> departmentMap = new HashMap<Integer, String>();
		
		 List<Object[]> departments =  sessionFactory.getCurrentSession().createSQLQuery("select id, name from department ").list();
		
		 for(Object[] department : departments) {
			 departmentMap.put((Integer)department[0], (String)department[1]);
		 }
		 
		 return departmentMap;
	}



	public void create(Department department){
		sessionFactory.getCurrentSession().save(department);
	}



	public List getAllDepartments(){
		return sessionFactory.getCurrentSession().createQuery("from Department").list();
	}



	public void update(Department department){
		sessionFactory.getCurrentSession().update(department);
	}



	public void delete(int id){
		sessionFactory.getCurrentSession().delete(getDepartmentById(id));
		
	}



	public Department getDepartmentById(int id){
		return (Department) sessionFactory.getCurrentSession().get(Department.class, id);
	
	}
		
}	
	
	


