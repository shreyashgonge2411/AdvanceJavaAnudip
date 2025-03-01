package com.student.controller;

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

import com.student.entity.Student;
import com.student.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public List<Student> getAll(){
		return studentService.getAllStudent();
	}
	
	@PostMapping
	public Student addStudent(@Valid@RequestBody Student student) {
		return studentService.createEntry(student);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudentById(@PathVariable Long id,@Valid @RequestBody Student student) {
		Student existing = studentService.getStudentById(id);
		if(existing != null) {
			existing.setName(student.getName());
			existing.setAddress(student.getAddress());
			existing.setNumber(student.getNumber());
			
			Student save = studentService.updateStudentById(existing);
			return ResponseEntity.ok(save);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deteleStudentById(@PathVariable Long id){
		boolean exist = studentService.deleteStudentById(id);
		if(exist) {
			return ResponseEntity.noContent().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
