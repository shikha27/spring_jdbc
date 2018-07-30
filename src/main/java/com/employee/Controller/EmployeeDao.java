package com.employee.Controller;
import com.employee.Model.*;

import java.sql.SQLException;
import java.util.List;
public interface EmployeeDao {

	public void save(AddModel employee);
	
	public void update(AddModel employee);

	public void deleteById(int id);
	
	public List<AddModel> getAll() throws SQLException;

}
