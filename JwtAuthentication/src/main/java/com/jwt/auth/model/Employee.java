package com.jwt.auth.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "Auth")
@Data
public class Employee {
	
	@Id 
	private Integer emp_id;
	private String emp_name;
	private String emp_details;
	public Employee(int emp_id, String emp_name, String emp_details) {
		super();
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.emp_details = emp_details;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public String getEmp_details() {
		return emp_details;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public void setEmp_details(String emp_details) {
		this.emp_details = emp_details;
	}
	
	
}
