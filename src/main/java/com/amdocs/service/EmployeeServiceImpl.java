package com.amdocs.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amdocs.Entity.Employee;
import com.amdocs.jpaRepo.EmployeeRepository;

@Service
public class EmployeeServiceImpl  implements EmployeeService{
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public List<Employee> fetchAllEmployee(){
		List<Employee> allEmployees=employeeRepository.findAll();
		return allEmployees;
	}
	
	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee>employee=employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		return null;
	}
	
	@Override
	public Employee updateEmployeeById(Long id,Employee employee) {
		Optional<Employee> employee1=employeeRepository.findById(id);
		if(employee1.isPresent()) {
			Employee originalEmployee=employee1.get();
			if(Objects.nonNull(employee.getFirstName()) && !"".equalsIgnoreCase(employee.getFirstName())){
				originalEmployee.setFirstName(employee.getFirstName());
				
			}
			if(Objects.nonNull(employee.getLastName()) && !"".equalsIgnoreCase(employee.getLastName())){
				originalEmployee.setLastName(employee.getLastName());
				
			}
			if(Objects.nonNull(employee.getEmail()) && !"".equalsIgnoreCase(employee.getEmail())){
				originalEmployee.setEmail(employee.getEmail());
				
			}


			return employeeRepository.save(originalEmployee);
		}
		return null;
	}
	
	@Override
	public String deleteEmployeeById(Long id) {
		if(employeeRepository.findById(id).isPresent()) {
			employeeRepository.deleteById(id);
			return "Employee Successfully deleted";
		}
		return "No such employee in the database";
	}
	
}
