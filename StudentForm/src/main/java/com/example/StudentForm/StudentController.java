package com.example.StudentForm;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students/api")
public class StudentController {
	
	private StudentService studentService;
	
	@GetMapping
	public List<Student> fetchAllStudents(){
		return studentService.getAllStudents();
		
	}

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

}
