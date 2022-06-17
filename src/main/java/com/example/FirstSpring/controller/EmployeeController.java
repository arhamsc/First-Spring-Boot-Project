package com.example.FirstSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.FirstSpring.entity.Employee;
import com.example.FirstSpring.service.EmployeeService;

import java.util.List;

@RestController // Api controllers
public class EmployeeController {
	// This controller is the API Methods and which calls the service
	@Autowired
	private EmployeeService empService;

	@PostMapping("/addNewEmployee") // this is to tell that below is the code to be run on post route and url is //
									// inside it.
	public Employee postEmployee(@RequestBody Employee employee, String extra) { // this is the post ROUTE of the api.
		int a = 10;
		System.out.println("Extra: +++" + a);
		return empService.addEmployee(employee);
	}

	@GetMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		return empService.getAllEmployees();
	}

	@GetMapping("/getEmpById/{id}")
	public Employee getEmpById(@PathVariable int id) {
		return empService.findEmployeeById(id);
	}

	@PatchMapping("/patchEmp/{id}")
	public Employee patchEmp(@RequestBody Employee employee, @PathVariable int id) {
		return empService.patchEmployee(employee, id);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id) {
		empService.deleteEmployee(id);
		return "Deleted";
	}

	@GetMapping("/getByName/{name}")
	public List<Employee> getEmpByName(@PathVariable String name) {
		return empService.findEmpByName(name);
	}

	@GetMapping("/getByDesignation")
	public List<Employee> getEmpByDesignation(@RequestParam String designation) {
		return empService.findByDesignation(designation);
	}

}
