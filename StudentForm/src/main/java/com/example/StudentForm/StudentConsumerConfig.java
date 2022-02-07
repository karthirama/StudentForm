package com.example.StudentForm;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

@Configuration
public class StudentConsumerConfig {
	
	@Value("${spring.kafka.bootstrap-servers}")
	private String bootstrapServers;
	
	public Map<String,Object> consumerConfig(){
		Map<String,Object> props=new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
		return props;
	}
	@Bean
	public ConsumerFactory<String, Student> consumerFactory(){
		return new DefaultKafkaConsumerFactory<>(consumerConfig(), null, new JsonDeserializer<Student>(Student.class));

	}
	
	
	public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Student>> listenerFactory(ConsumerFactory<String, Student> consumerFactory){
		
		ConcurrentKafkaListenerContainerFactory<String, Student> factory=new ConcurrentKafkaListenerContainerFactory<>();
		
		 factory.setConsumerFactory(consumerFactory);
		 
		 return factory;
	}
}
