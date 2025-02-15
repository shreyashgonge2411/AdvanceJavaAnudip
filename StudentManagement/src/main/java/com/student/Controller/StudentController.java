package com.student.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.Entity.Student;

@RestController
//@RequestMapping("student")
public class StudentController {

	private Map<Long, Student> myStudent = new HashMap<>();
	
	@GetMapping
	public List<Student> getAll(){
		return new ArrayList<>(myStudent.values());
	}
	
	@PostMapping("/register")
	public boolean createEntry(@RequestBody Student student) {
		myStudent.put(student.getId(), student);
		return true;
	}
	
	@GetMapping("id/{myId}")
	public Student findStudentByID(@PathVariable Long myId) {
		return myStudent.get(myId);
	}
	
	@DeleteMapping("id/{myId}")
	public Student deleteStudentByID(@PathVariable Long myId) {
		return myStudent.remove(myId);
	}
	
	public Student updateStudentById(@PathVariable Long myId,@RequestBody Student student) {
		return myStudent.put(myId, student);
	}
}
