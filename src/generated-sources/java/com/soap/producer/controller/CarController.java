package com.soap.producer.controller;

import com.soap.Car;
import com.soap.producer.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;
    private static final Logger logger = LoggerFactory.getLogger(CarController.class);


    @RequestMapping("/cars")
    public List<Car> getCarsRequest() {

        return carService.getCars();
    }

    @PostMapping("/rent")
    public Car rentCarRequest(@RequestBody Car car) {
        if (car.getId() != 0 && car.getCustomerName() != null && car.getEndDate() != null) {

            return carService.rentCar(car.getId(),  car.getCustomerName(), car.getEndDate());
        } else
            return null;
    }
}
