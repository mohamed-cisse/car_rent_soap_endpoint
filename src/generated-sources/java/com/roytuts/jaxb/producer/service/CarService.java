package com.roytuts.jaxb.producer.service;

import com.roytuts.jaxb.Car;
import com.roytuts.jaxb.producer.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class CarService {
    @Autowired
    CarRepository carRepository ;


    public List<Car> getCars(String name) {
        List<Car> CarList = new ArrayList<>();
        LocalDateTime currentDate = LocalDateTime.now();

        for (Car car : carRepository.findAll()) {
            //car.getModel().toLowerCase().contains(name.toLowerCase())
            if(car.getEndDate()!=null) {
                if (checkAvailable(car.getEndDate(),currentDate)) {

                    CarList.add(car);
                }
            }
            else
            {
                CarList.add(car);
            }
        }
        return CarList;
    }

    public boolean checkAvailable(String date, LocalDateTime current) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        try {
            Date date1 = sdf.parse(date);
            LocalDateTime date2= LocalDateTime.ofInstant(date1.toInstant(), ZoneId.systemDefault());

            if(current.isAfter(date2))
            {
                return true;
            }
            else return false;
        }catch (Exception e)
        {
            return false;
        }


    }
    public Car rentCar(int id, String cusName, String endDate)
    {
        for (Car car : carRepository.findAll()) {
            if (car.getId()==id)
            {
                car.setEndDate(endDate);
                car.setCustomerName(cusName);
                carRepository.save(car);
                return car;
//				return "Success/n car id: "+ car.getId()+" Model: "+car.getModel()
//						+"Customer name: "+car.getCustomerName()+"Rent end date: "+car.getEndDate();
            }

        }
        return null;
    }
}
