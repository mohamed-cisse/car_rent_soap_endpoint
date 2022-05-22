package com.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.soap.producer")
public class SpringSoapProducerApp  {

	public static void main(String[] args) {
		SpringApplication.run(SpringSoapProducerApp.class, args);
	}

}
