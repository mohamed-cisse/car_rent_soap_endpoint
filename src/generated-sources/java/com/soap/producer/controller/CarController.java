package com.soap.producer.controller;

import com.soap.Car;
import com.soap.producer.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("rent/{id}/{cusName}/{endDate}")
    public Car rentCarRequest(@PathVariable int id, @PathVariable String cusName, @PathVariable String endDate) {
        if (id != 0 && cusName != null && endDate != null) {

            return carService.rentCar(id, cusName, endDate);
        } else
            return null;
    }
}
