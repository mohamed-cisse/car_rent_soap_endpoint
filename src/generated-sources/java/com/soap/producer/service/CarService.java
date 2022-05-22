package com.soap.producer.service;

import com.soap.Car;
import com.soap.producer.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


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
        return CarList;
    }


    public Car rentCar(int id, String cusName, Date endDate) {

        Car car = carRepository.findById(id).get();
        if(!car.equals(null))
        {
                car.setEndDate(endDate);
                car.setCustomerName(cusName);
                carRepository.save(car);
        return car;
        }

        return null;
    }

//    public boolean checkAvailable(Date date, LocalDateTime current) {
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//
//        try {
//
//            LocalDateTime date2= LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
//
//            if(current.isAfter(date2))
//            {
//                return true;
//            }
//            else return false;
//        }catch (Exception e)
//        {
//            return false;
//        }
//
//
//    }
}