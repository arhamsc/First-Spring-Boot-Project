package com.example.FirstSpring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity //we have to notify that this is the entity class
@Table(name="My_Employees")
public class Employee {
	
	//This  is an entity with all required attributes
	//similar to model or schema in mongoose and node
	//Private to show the encapsulation
	
	@Id//this is to specify the primary key.
	@GeneratedValue //this means that it will be generated automatically
	private int empId;
	private String empName;
	private String designation;
	private Float salary;

}
