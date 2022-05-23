package com.soap.producer.database;

import com.soap.producer.generated.Car;
import com.soap.producer.repository.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
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
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        Car car1 = new Car();
        car1.setId(1);
        car1.setModel("Toyota");


        Car car2 = new Car();
        car2.setId(2);
        car2.setModel("BMW");
        car2.setEndDate(sdf.parse("16-05-2022"));

        Car car3 = new Car();
        car3.setId(3);
        car3.setModel("WW");


        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        for( Car car: cars)
        {
           carRepository.save(car);
        }


    }
}
