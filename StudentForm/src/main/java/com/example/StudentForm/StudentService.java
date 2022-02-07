package com.example.StudentForm;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	private StudentRepository studentRepository;	

	public List<Student> getAllStudents() {
		
		return studentRepository.findAll();
		
	}

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

}
