package com.employee.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "employee")
public class Employee {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int id;
	@Column(name="name")
	String name;
	@Column(name="salary")
	Double salary;
	@Column(name="departmentid")
	int departmentid;
	 
	
	public Employee() {
		
	}
	
	
	public Employee(int id, String name, Double salary, int departmentid) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.departmentid = departmentid;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public int getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}

}
