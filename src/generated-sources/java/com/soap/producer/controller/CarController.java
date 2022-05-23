package com.soap.producer.controller;

import com.soap.producer.converter.Converter;
import com.soap.producer.generated.CarDto;
import com.soap.producer.generated.Car;
import com.soap.producer.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;
    @Autowired
    Converter converter;
//    private static final Logger logger = LoggerFactory.getLogger(CarController.class);


    @RequestMapping("/cars")
    public List<CarDto> getCarsRequest() {

        return converter.entityToDtoList(carService.getCars());
    }

    @PostMapping("/rent")
    public CarDto rentCarRequest(@RequestBody CarDto dto) {

            return converter.entityToDto( carService.rentCar(converter.DtoToEntity(dto))) ;

    }


}
