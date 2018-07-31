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
	Connection connection = null;
	PreparedStatement preparedStatement = null;

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void update(Employee employee) throws SQLException {
		String query = "update employee set name=?, salary=?, department=? where id=?";

		connection = dataSource.getConnection();
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setDouble(2, employee.getSalary());
		preparedStatement.setString(3, employee.getDepartment());
		preparedStatement.setInt(4, employee.getId());

		int out = preparedStatement.executeUpdate();
		if (out != 0) {
			System.out.println("Employee updated with id=" + employee.getId());
		} else
			System.out.println("No Employee found with id=" + employee.getId());

	}

	public Employee getEmployeeById(int id) throws SQLException {
		String query = "select* from employee where id=?";

		Employee emp = null;

		ResultSet rs = null;

		connection = dataSource.getConnection();
		preparedStatement = connection.prepareStatement(query);

		preparedStatement.setInt(1, id);
		rs = preparedStatement.executeQuery();
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

		ResultSet rs = null;

		connection = dataSource.getConnection();
		preparedStatement = connection.prepareStatement(query);
		rs = preparedStatement.executeQuery();
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

	public void create(Employee employee) throws SQLException {

		String query = "insert into employee values(?,?,?,?)";

		connection = dataSource.getConnection();
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setDouble(3, employee.getSalary());
		preparedStatement.setString(4, employee.getDepartment());
		int out = preparedStatement.executeUpdate();
		if (out != 0) {
			System.out.println("Employee saved with id=" + employee.getId());
		} else
			System.out.println("Employee save failed with id=" + employee.getId());
	}

	public void delete(int id) throws SQLException {
		String query = "delete from employee where id=?";

		connection = dataSource.getConnection();
		preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		int out = preparedStatement.executeUpdate();
		if (out != 0) {
			System.out.println("Employee deleted with id=" + id);
		} else
			System.out.println("No Employee found with id=" + id);
	}

}
