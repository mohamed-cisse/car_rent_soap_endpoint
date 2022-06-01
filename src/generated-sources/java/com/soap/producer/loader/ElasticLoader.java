package com.soap.producer.loader;

import com.soap.producer.domain.Car;
import com.soap.producer.domain.CarElasticSearch;
import com.soap.producer.repository.ElasRepository;
import com.soap.producer.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component

public class ElasticLoader implements CommandLineRunner {


    ElasRepository elasRepository;

    CarService carService;
    @Autowired
    public ElasticLoader(ElasRepository elasRepository, CarService carService) {
        this.elasRepository = elasRepository;
        this.carService = carService;
    }

    @Override
    public void run(String... args) throws Exception {

        List<CarElasticSearch> cars = new ArrayList<CarElasticSearch>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        CarElasticSearch car1 = new CarElasticSearch();
        car1.setId(1);
        car1.setModel("Toyota");


        CarElasticSearch car2 = new CarElasticSearch();
        car2.setId(2);
        car2.setModel("BMW");
        car2.setEndDate(sdf.parse("16-05-2022"));

        CarElasticSearch car3 = new CarElasticSearch();
        car3.setId(3);
        car3.setModel("WW");


        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        elasRepository.saveAll(cars);
    //        for( CarElasticSearch car: cars)
//        {
//            elasRepository.saveAll(car);
//        }
      //  elasRepository.saveAll(carService.getCars());

    }
}
