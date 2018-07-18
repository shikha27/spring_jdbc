package com.employee.Controller;
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
//import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
//import com.javatpoint.beans.Emp;  
import com.employee.Model.*;
  
public class EmpDao {
	
	JdbcTemplate template;  
	  
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	public int save(AddModel p){  
	    String sql="insert into employee(id,name,salary,department) values('"+p.getId()+"',"+p.getName()+",'"+p.getSalary()+"',"+p.getDepartment()+")";
	            
	    return template.update(sql);  
	} 
	
	public List<AddModel> getEmployees(){  
	    return template.query("select * from employee",new RowMapper<AddModel>(){  
	        public AddModel mapRow(ResultSet rs, int row) throws SQLException {  
	            AddModel e=new AddModel();  
	            e.setId(rs.getInt(1));  
	            e.setName(rs.getString(2));  
	            e.setSalary(rs.getDouble(3));  
	            e.setDepartment
	            (rs.getString(4));  
	            return e;  
	        }  
	    });  

}
}
