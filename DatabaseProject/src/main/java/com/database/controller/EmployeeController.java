package com.database.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.database.entity.Employee;
import com.database.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//getting data by GetMapping
	@GetMapping
	public List<Employee> getAll(){
		return employeeService.getAll();
	}
	
	@PostMapping //Insert data using a PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
	
	@PutMapping("/{id}") //update Employee data by using a PutMapping
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee){
		Employee existingEmployee = employeeService.getEmployeeById(id);
		if(existingEmployee != null) {
			existingEmployee.setName(employee.getName());
			existingEmployee.setEmail(employee.getEmail());
			
			Employee savedEmployee = employeeService.updateEmployee(existingEmployee);
			return ResponseEntity.ok(savedEmployee);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id){ 
		boolean isDeleted = employeeService.deleteEmployeeById(id);
		if(isDeleted) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
