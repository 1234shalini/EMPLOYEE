package com.amdocs.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amdocs.Entity.Employee;
import com.amdocs.service.EmployeeService;

@RestController
public class MyController {
	@Autowired
	private EmployeeService employeeservice;
	
	@PostMapping("/api/employees")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeservice.saveEmployee(employee);
	}
	
	@GetMapping("/api/employees")
	public List<Employee>getAllEmployees(){
		return employeeservice.fetchAllEmployee();
	}
		
	@GetMapping("/api/employees/{id}")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return employeeservice.getEmployeeById(id);
	}
	
	@PutMapping("/api/employees/{id}")
	public Employee updateEmployee(@PathVariable("id") Long id,@RequestBody Employee employee) {
		return employeeservice.updateEmployeeById(id, employee);
		
	}
	@DeleteMapping("/api/employees/{id}")
	public String deleteEmployee(@PathVariable("id") Long id) {
		return employeeservice.deleteEmployeeById(id);
	}
}


