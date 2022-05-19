package com.soap.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.soap.producer.producer")
public class SpringSoapProducerApp  {

	public static void main(String[] args) {
		SpringApplication.run(SpringSoapProducerApp.class, args);
	}

}
