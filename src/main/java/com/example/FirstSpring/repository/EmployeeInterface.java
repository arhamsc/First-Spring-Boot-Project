package com.example.FirstSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.FirstSpring.entity.Employee;

import java.util.List;

@Repository
public interface EmployeeInterface extends JpaRepository<Employee, Integer> { //this is super class is from the JPA
	//the parameters in above jpsRepository the first is the entity we want to make it for and the second is the return type of Primary Key
	//This file only exsists to extend the JPA Repository and provides the CRUD Operations.
	
	List<Employee> findByEmpName(String name);
	//List<Employee> findByDesignation(String designtion);
}
