package com.employee.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//import org.springframework.stereotype.Repository;

import com.employee.Model.*;

//@Repository
public class EmployeeDAOImpl implements EmployeeDao{
	
	//step1:-
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource){
		
		this.dataSource=dataSource;
	}
	
	//step2:-give implementation to methods

	
	public void save(AddModel employee) {
		String query = "insert into employee values(?,?,?,?)";
		
		Connection con = null;
		PreparedStatement ps = null;
		
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setDouble(3, employee.getSalary());
			ps.setString(4, employee.getDepartment());
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Employee saved with id="+employee.getId());
			}else System.out.println("Employee save failed with id="+employee.getId());
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public void update(AddModel employee) {
		String query= "update employee set name=?, salary=?, department=? where id=?";
		
		Connection con = null;
		PreparedStatement ps = null;
		
		
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setString(1, employee.getName());
			ps.setDouble(2, employee.getSalary());
			ps.setString(3, employee.getDepartment());
			ps.setInt(4, employee.getId());

			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Employee updated with id="+employee.getId());
			}else System.out.println("No Employee found with id="+employee.getId());
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	


	public void deleteById(int id) {
		String query = "delete from employee where id=?";
		Connection con = null;
		PreparedStatement ps = null;
		try{
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int out = ps.executeUpdate();
			if(out !=0){
				System.out.println("Employee deleted with id="+id);
			}else System.out.println("No Employee found with id="+id);
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public AddModel getById(int id) throws SQLException {
		String query= "select* from employee where id=?";
		
		
		AddModel emp=null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				emp = new AddModel();
				emp.setId(id);
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setDepartment(rs.getString("department"));
				
			}
		
		return emp;
	}
	

	

	public List<AddModel> getAll() throws SQLException {
		String query= "select* from employee";
		
		List<AddModel> employeeList= new ArrayList<AddModel>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while(rs.next()){
				AddModel emp = new AddModel();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setDepartment(rs.getString("department"));
				employeeList.add(emp);
			}
		return employeeList;
	}
}
	
