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
	    String sql="insert into employee values(?,?,?,?)";
	            
	    return template.update(sql,p.getId(),p.getName(),p.getSalary(),p.getDepartment());  
	} 
	
	public List<AddModel> getEmployees(){  
		
		String sql = "select * from employee";
		
		RowMapper<AddModel> rowMapper = new RowMapper<AddModel>() {

			public AddModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				  AddModel e=new AddModel();  
		            e.setId(rs.getInt(1));  
		            e.setName(rs.getString(2));  
		            e.setSalary(rs.getDouble(3));  
		            e.setDepartment(rs.getString(4));
		              
		            return e;  
			}
		};
		
		 List<AddModel> addModels = template.query(sql,rowMapper);  
		 return addModels;

}
}
