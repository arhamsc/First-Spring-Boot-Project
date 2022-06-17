package com.example.FirstSpring.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.FirstSpring.entity.Employee;
import com.example.FirstSpring.repository.EmployeeInterface;


@Service
public class EmployeeService {

	@Autowired // binding the interface to the service.
	private EmployeeInterface empInterface;

	public Employee addEmployee(Employee employee) {
		return empInterface.save(employee); // CRUD method of C - Saving to the database. this is provided from the
											// super the interface extends from.
	}

	public List<Employee> getAllEmployees() {
		return empInterface.findAll();
	}
	
	//find by id
	public Employee findEmployeeById(int id) {
		try {
			return empInterface.findById(id).orElseThrow(() -> new NoSuchFieldException());
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Employee employee = new Employee();
			employee.setEmpId(9999);
			employee.setDesignation("empty");
			employee.setEmpName("empty");
			employee.setSalary(0F);
			return employee;
		}
	}
	
	//patch
	public Employee patchEmployee(Employee employee, int id) {
		
		return empInterface.findById(id).map(ele -> {
			ele.setDesignation(employee.getDesignation());
			ele.setEmpName(employee.getEmpName());
			ele.setSalary(employee.getSalary());
			return empInterface.save(ele);
		}).orElseGet(() -> {
			employee.setEmpId(id);
			return empInterface.save(employee);
		});
	}
	
	//delete employee
	public void deleteEmployee(int id) {
		empInterface.deleteById(id);
	}
	
	//Get my name
	public List<Employee> findEmpByName(String name) {
		return empInterface.findByEmpName(name);
	}
	
	//Get by designation
	public List<Employee> findByDesignation(String designation) {
		return empInterface.findByDesignation(designation);
	}
}
