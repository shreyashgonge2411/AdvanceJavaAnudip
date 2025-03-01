package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentrepo;
	
	public List<Student> getAllStudent(){
		return studentrepo.findAll();
	}
	
	public Student createEntry(Student student) {
		return studentrepo.save(student);
	}
	
	public Student updateStudentById(Student student) {
		return studentrepo.save(student);
	}
	
	public Student getStudentById(Long id) {
		return studentrepo.findById(id).orElse(null);
	}
	
	public boolean deleteStudentById(Long id) {
		if(studentrepo.existsById(id)) {
			studentrepo.deleteById(id);
			return true;
		}else {
			return false;
		}
	}
}
