package com.soap.producer.notificationservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soap.producer.domain.Car;
import com.soap.producer.domain.CarDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class NotificationService {
    @Autowired
    private EmailSenderService senderService;

    @KafkaListener(topics = "CarRenting", groupId = "group1")
    public void listener(String data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        CarDto car = mapper.readValue(data, CarDto.class);
        senderService.sendSimpleEmail(car.getCustomerEmail(),
                "Car rent confirmation",
                "This is to confirm renting car modle: " +
                        car.getModel()+"\n end date: " + car.getEndDate()
        );

    }
}
