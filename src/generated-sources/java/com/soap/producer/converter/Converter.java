package com.soap.producer.converter;

import com.soap.producer.errorhandler.MissingRentDataException;
import com.soap.producer.generated.Car;
import com.soap.producer.generated.CarDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {

    public CarDto entityToDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setCustomerName(car.getCustomerName());
        carDto.setEndDate(car.getEndDate());
        carDto.setModel(car.getModel());

        return carDto;
    }

    public Car DtoToEntity(CarDto carDto) {
        Car car = new Car();
        if (isEmpty(carDto)) {
            car.setId(carDto.getId());
            car.setCustomerName(carDto.getCustomerName());
            car.setEndDate(carDto.getEndDate());
            car.setModel(carDto.getModel());
        } else throw new MissingRentDataException();
        return car;
    }

    public List<CarDto> entityToDtoList(List<Car> cars) {
        return cars.stream().map(car -> entityToDto(car)).collect(Collectors.toList());
    }

    public List<Car> DtoToEntityList(List<CarDto> carDtos) {
        return carDtos.stream().map(carDto -> DtoToEntity(carDto)).collect(Collectors.toList());
    }

    public boolean isEmpty(CarDto dto) {
        if (dto.getId() <= 0 || dto.getCustomerName().isEmpty() || dto.getEndDate() == null) {
            throw new MissingRentDataException();
        } else return true;
    }
//    public boolean isEmpty(Car car)
//    {
//        if (car.getId()<= 0 || car.getCustomerName() == null || car.getEndDate() == null)
//        {
//            throw new MissingRentDataException();
//        }
//        else return true;
//    }
}
