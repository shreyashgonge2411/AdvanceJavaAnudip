package com.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.database.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
	
}
