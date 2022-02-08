package com.example.StudentForm;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

@Configuration
public class StudentProducerConfig {
	
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;
	
	public Map<String,Object> producerConfig(){
		Map<String,Object> props=new HashMap<>();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		//props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

		return props;
	}
	@Bean
	public ProducerFactory<String, Student> producerFactory(){
		return new DefaultKafkaProducerFactory<>(producerConfig());
	}
	
	@Bean
	public KafkaTemplate<String, Student> kafkaTemplate(ProducerFactory<String, Student> producerFactory){
		return new KafkaTemplate<>(producerFactory);
		
	}
	
	
	/*public void sendData(Student student) {
		
		KafkaTemplate<String, Student> kafkaTemplate
		// TODO Auto-generated method stub
		Map<String, Object> headers = new HashMap<>();
		headers.put(KafkaHeaders.TOPIC, topicName);
		kafkaTemplate.send(new GenericMessage<Student>(student, headers));
		// use the below to send String values through kafka
		// kafkaTemplate.send(topicName, "some string value")
		LOGGER.info("Data - " + student.toString() + " sent to Kafka Topic - " + topicName);
	}*/

}
