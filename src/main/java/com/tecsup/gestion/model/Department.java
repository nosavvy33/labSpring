package com.tecsup.gestion.model;

public class Department {
/*
 `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(90) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  
  */
	public Department(int department_id, String name, String description, String city) {
	super();
	this.department_id = department_id;
	this.name = name;
	this.description = description;
	this.city = city;
}
	private int department_id;

	public Department() {
		super();
	}
	private String name;
	private String description;
	private String city;
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
}
