package com.example.StudentForm;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class StudentFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentFormApplication.class, args);
	}
	
	@Bean
	CommandLineRunner runner(KafkaTemplate<String, Student> kafkaTemplate) {

		return args -> {
			kafkaTemplate.send("studentTopic",new Student("Rama", 26, "M", LocalDateTime.now()));
		};
		
	}

}
