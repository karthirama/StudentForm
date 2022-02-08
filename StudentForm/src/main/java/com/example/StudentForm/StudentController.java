package com.example.StudentForm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private KafkaTemplate<String, Student> kafkaTemplate;
	
	@GetMapping
	public List<Student> fetchAllStudents(){
		return studentService.getAllStudents();
		
	}

		@PostMapping("/publish")
		public ResponseEntity<String> sendData(@RequestBody Student data){
			kafkaTemplate.send("studentTopic",data);
			return new ResponseEntity<>("Data sent to Kafka", HttpStatus.OK);
		}

}
