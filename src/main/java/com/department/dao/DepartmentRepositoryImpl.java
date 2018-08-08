package com.department.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.department.model.Department;


@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository{

	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	@Autowired
	private DataSource dataSource;

	
	public Map<Integer, String> getDepartmentIdAndName() throws SQLException {
		
		String query= "select id, name from department";
		
		Map<Integer,String> deptobj = new HashMap<Integer,String>();
		
		ResultSet rs = null;

		connection = dataSource.getConnection();
		preparedStatement = connection.prepareStatement(query);
		rs= preparedStatement.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String name=rs.getString("name");
			deptobj.put(id, name);
			}
		return deptobj;
		
	}
	
	
	
	private int getMaxId() throws SQLException {
		int id=0;
		String query= "select max(id) as id from department order by id desc";
		ResultSet rs = null;

		connection = dataSource.getConnection();
		preparedStatement = connection.prepareStatement(query);
		rs= preparedStatement.executeQuery();
		rs.next();
		id= rs.getInt("id");
		return id;
		
	}
	
	
	public void create(Department department) throws SQLException {
		
		String query = "insert into department values(?,?,?,?)";

		int id = getMaxId();
		department.setId(++id);
		connection = dataSource.getConnection();
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, department.getId());
		preparedStatement.setString(2, department.getName());
		preparedStatement.setString(3, department.getLocation());
		preparedStatement.setInt(4, department.getBonus());
		int out = preparedStatement.executeUpdate();
		if (out != 0) {
			System.out.println("Department saved with id=" + department.getId());
		} else
			System.out.println("Department save failed with id=" + department.getId());
	}

	public List<Department> getAllDepartments() throws SQLException {

		String query = "select* from department";

		List<Department> departmentList = new ArrayList<Department>();

		ResultSet rs = null;

		connection = dataSource.getConnection();
		preparedStatement = connection.prepareStatement(query);
		rs = preparedStatement.executeQuery();
		while (rs.next()) {
			Department dept = new Department();
			dept.setId(rs.getInt("id"));
			dept.setName(rs.getString("name"));
			
			dept.setLocation(rs.getString("location"));
			dept.setBonus(rs.getInt("bonus"));
			departmentList.add(dept);
		}
		return departmentList;
	}

	public void update(Department department) throws SQLException {
		String query = "update department set name=?, location=?, bonus=? where id=?";

		connection = dataSource.getConnection();
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, department.getName());
		preparedStatement.setString(2, department.getLocation());
		preparedStatement.setInt(3, department.getBonus());
		
		preparedStatement.setInt(4, department.getId());
		

		int out = preparedStatement.executeUpdate();
		if (out != 0) {
			System.out.println("Department updated with id=" + department.getId());
		} else
			System.out.println("No Department found with id=" + department.getId());

	}
		
	

	public void delete(int id) throws SQLException {
		String query = "delete from department where id=?";

		connection = dataSource.getConnection();
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		int out = preparedStatement.executeUpdate();
		if (out != 0) {
			System.out.println("Department deleted with id=" + id);
		} else
			System.out.println("No department found with id=" + id);
	}
		
	

	public Department getDepartmentById(int id) throws SQLException {
		String query = "select* from department where id=?";
		Department dept = null;
		ResultSet rs = null;

		connection = dataSource.getConnection();
		preparedStatement = connection.prepareStatement(query);

		preparedStatement.setInt(1, id);
		rs = preparedStatement.executeQuery();
		while (rs.next()) {
			dept = new Department();
			dept.setId(id);
			dept.setName(rs.getString("name"));
			dept.setLocation(rs.getString("location"));
			dept.setBonus(rs.getInt("bonus"));
          
		}

		return dept;
	}
	}

	
	
		
	
	


