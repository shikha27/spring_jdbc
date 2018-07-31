package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.stereotype.Repository;

import com.employee.model.*;

public class EmployeeRepositoryImpl implements EmployeeRepository {

	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	// step2:-give implementation to methods

	public void update(Employee employee) {
		String query = "update employee set name=?, salary=?, department=? where id=?";

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
			if (out != 0) {
				System.out.println("Employee updated with id=" + employee.getId());
			} else
				System.out.println("No Employee found with id=" + employee.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public Employee getEmployeeById(int id) throws SQLException {
		String query = "select* from employee where id=?";

		Employee emp = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		con = dataSource.getConnection();
		ps = con.prepareStatement(query);

		ps.setInt(1, id);
		rs = ps.executeQuery();
		while (rs.next()) {
			emp = new Employee();
			emp.setId(id);
			emp.setName(rs.getString("name"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setDepartment(rs.getString("department"));

		}

		return emp;
	}

	public List<Employee> getAllEmployees() throws SQLException {
		String query = "select* from employee";

		List<Employee> employeeList = new ArrayList<Employee>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		con = dataSource.getConnection();
		ps = con.prepareStatement(query);
		rs = ps.executeQuery();
		while (rs.next()) {
			Employee emp = new Employee();
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setSalary(rs.getDouble("salary"));
			emp.setDepartment(rs.getString("department"));
			employeeList.add(emp);
		}
		return employeeList;
	}

	public void create(Employee employee) {

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
			if (out != 0) {
				System.out.println("Employee saved with id=" + employee.getId());
			} else
				System.out.println("Employee save failed with id=" + employee.getId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void delete(int id) {
		String query = "delete from employee where id=?";
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = dataSource.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			int out = ps.executeUpdate();
			if (out != 0) {
				System.out.println("Employee deleted with id=" + id);
			} else
				System.out.println("No Employee found with id=" + id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
