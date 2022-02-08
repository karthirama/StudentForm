package com.example.StudentForm;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StudentListener {
	
	private StudentRepository studentRepository;	

	
	public StudentListener(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	/*@KafkaListener(topics="studentTopic",groupId="groupId")
	void Listener(String data) {
		System.out.println("Data Received "+data);
		//studentRepository.insert(data);
	}*/
	
	@KafkaListener(topics="studentTopic",groupId="groupId",containerFactory = "listenerFactory")
	public void recieveData(Student student) {
		studentRepository.insert(student);
		System.out.println("Data - " + student.toString() + " recieved");
	}
	

}
