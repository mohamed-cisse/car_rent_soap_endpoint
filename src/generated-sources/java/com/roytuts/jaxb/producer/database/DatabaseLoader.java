package com.roytuts.jaxb.producer.database;

import com.roytuts.jaxb.Car;
import com.roytuts.jaxb.producer.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class DatabaseLoader implements CommandLineRunner {

    private CarRepository carRepository;
    public DatabaseLoader(CarRepository carRepository) {
        this.carRepository=carRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        List<Car> cars = new ArrayList<Car>();


        Car car1 = new Car();
        car1.setId(1);
        car1.setModel("Toyota");


        Car car2 = new Car();
        car2.setId(2);
        car2.setModel("BMW");
        car2.setEndDate("16-05-2022");

        Car car3 = new Car();
        car3.setId(3);
        car3.setModel("WW");
        car3.setEndDate("20-05-2022");

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        for( Car car: cars)
        {
           carRepository.save(car);
        }


    }
}
