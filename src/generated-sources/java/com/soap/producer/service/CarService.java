package com.soap.producer.service;

import com.soap.producer.errorhandler.CarNotFoundexption;
import com.soap.producer.errorhandler.CarRentedException;
import com.soap.producer.domain.Car;
import com.soap.producer.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


@Service
public class CarService {
    @Autowired
    CarRepository carRepository;


    public List<Car> getCars() {
        LocalDateTime currentDate = LocalDateTime.now();
        Date currentInstant = Date.from(currentDate.atZone(ZoneId.systemDefault()).toInstant());
        return carRepository.getCarByEndDateNullOrEndDateIsBefore(currentInstant);
    }


    public Car rentCar(Car car) {
//        LocalDateTime currentDate = LocalDateTime.now();
        //Date currentInstant = Date.from(currentDate.atZone(ZoneId.systemDefault()).toInstant());

        Car carTemp = carRepository.findById(car.getId()).orElseThrow(() -> new CarNotFoundexption());
        if (checkAvailable(carTemp.getEndDate(), car.getEndDate())) {
            carTemp.setEndDate(car.getEndDate());
            carTemp.setCustomerName(car.getCustomerName());
            carTemp.setCustomerEmail(car.getCustomerEmail());
            carRepository.save(carTemp);
            return car;
        } else {
            throw new CarRentedException();
        }
    }


    public boolean checkAvailable(Date date, Date endDate) {

        if (date == null) {
            return true;
        }

        return endDate.after(date);


    }
//    public boolean isPresent(Car car) {
//
//        if (date == null) {
//            return true;
//        }
//
//        return endDate.after(date);
//
//
//    }
//
//    public boolean checkRentDetails(GetCarDetailsRequest request) {
//    if(request.getEndDate() == null || request.getCustomerName() == null &|| request.getId() == null)
//    {
//
//    }
//    }
}