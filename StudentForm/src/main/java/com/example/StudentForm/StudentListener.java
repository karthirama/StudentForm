package com.example.StudentForm;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StudentListener {
	
	private StudentRepository studentRepository;	

	
	@KafkaListener(topics="studentTopic",groupId="groupId")
	void Listener(String data) {
		System.out.println("Data Received "+data);
		//studentRepository.insert(data);
	}

}
