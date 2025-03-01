package com.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.database.entity.Employee;
import com.database.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;
	
	//Getting all Data
	public List<Employee> getAll(){
		return employeeRepo.findAll();
	}
	
	//Save Data
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	//Update Data
	public Employee updateEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}
	
	//Get Employee By Id
	public Employee getEmployeeById(Long id) {
		return employeeRepo.findById(id).orElse(null);
	}
	
	//delete Employee By Id
	public boolean deleteEmployeeById(Long id) {
		if(employeeRepo.existsById(id)) {
			employeeRepo.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
	
	
}
