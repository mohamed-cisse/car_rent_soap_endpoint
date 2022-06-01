package com.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages ="com.soap.producer")
@SpringBootApplication(scanBasePackages = "com.soap.producer")
public class SpringSoapProducerApp  {

	public static void main(String[] args) {
		SpringApplication.run(SpringSoapProducerApp.class, args);
	}

}
