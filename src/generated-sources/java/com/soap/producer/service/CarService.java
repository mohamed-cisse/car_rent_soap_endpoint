package com.soap.producer.service;

import com.soap.Car;
import com.soap.producer.errorHandler.CarNotFoundexption;
import com.soap.producer.errorHandler.CarRentedException;
import com.soap.producer.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class CarService {
    @Autowired
    CarRepository carRepository;


    public List<Car> getCars() {
        List<Car> CarList = new ArrayList<>();
        LocalDateTime currentDate = LocalDateTime.now();
        Date out = Date.from(currentDate.atZone(ZoneId.systemDefault()).toInstant());

        for (Car car : carRepository.getCarByEndDateNullOrEndDateIsBefore(out)) {
            CarList.add(car);
        }
        if (CarList.isEmpty()) {
            throw new CarNotFoundexption();
        } else {
            return CarList;
        }

    }


    public Car rentCar(int id, String cusName, Date endDate) {
//        LocalDateTime currentDate = LocalDateTime.now();
        //Date currentInstant = Date.from(currentDate.atZone(ZoneId.systemDefault()).toInstant());


        if (carRepository.findById(id).isPresent()) {
            Car car = carRepository.findById(id).get();
            if (checkAvailable(car.getEndDate(), endDate)) {
                car.setEndDate(endDate);
                car.setCustomerName(cusName);
                carRepository.save(car);
                return car;
            } else {
                throw new CarRentedException();
            }
        } else {
            throw new CarNotFoundexption();
        }


    }

    public boolean checkAvailable(Date date, Date endDate) {

        if (date == null)
        {
            return true;
        }

        return endDate.after(date);


    }
}