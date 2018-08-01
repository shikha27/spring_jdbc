package com.department.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public void create(Department department) throws SQLException {
		
		String query = "insert into department values(?,?,?,?)";

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

	
	
		
	}
	


