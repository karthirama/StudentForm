package com.example.StudentForm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentFormApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentFormApplication.class, args);
	}
	
	/*@Bean
	CommandLineRunner runner(KafkaTemplate<String, Student> kafkaTemplate) {

		return args -> {
			kafkaTemplate.send("studentTopic",new Student("Rama", 26, "M", LocalDateTime.now()));
		};
		
	}*/

}
