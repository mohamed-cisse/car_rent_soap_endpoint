package com.soap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soap.producer.domain.Car;
import com.soap.producer.domain.CarDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.core.KafkaTemplate;

@EntityScan(basePackages ="com.soap.producer")
@SpringBootApplication(scanBasePackages = "com.soap.producer")
public class SpringSoapProducerApp  {

	public static void main(String[] args) {
		SpringApplication.run(SpringSoapProducerApp.class, args);
	}

}
