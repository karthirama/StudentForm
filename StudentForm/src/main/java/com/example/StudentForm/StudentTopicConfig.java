package com.example.StudentForm;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class StudentTopicConfig {
	
	@Bean
	public NewTopic studentTopic() {
		return TopicBuilder.name("studentTopic").build();
	}
	

}
