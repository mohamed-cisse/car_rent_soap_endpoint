package com.soap.producer.controller;

import com.soap.Car;
import com.soap.producer.errorHandler.CarNotFoundexption;
import com.soap.producer.errorHandler.CarRentedException;
import com.soap.producer.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;
//    private static final Logger logger = LoggerFactory.getLogger(CarController.class);


    @RequestMapping("/cars")
    public List<Car> getCarsRequest() {

        return carService.getCars();
    }

    @PostMapping("/rent")
    public ResponseEntity<?> rentCarRequest(@RequestBody Car car) {
        if (car.getId() != 0 && car.getCustomerName() != null && car.getEndDate() != null) {
            try {
                carService.rentCar(car.getId(), car.getCustomerName(), car.getEndDate());
            }catch (Exception ex)
            {
                throw new CarRentedException();
            }
            return new ResponseEntity<>(car, HttpStatus.OK);
        } else {
            throw new CarNotFoundexption();
        }
    }


}
