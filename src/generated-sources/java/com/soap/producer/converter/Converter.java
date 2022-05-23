package com.soap.producer;

import com.soap.producer.dto.GetCarDetailsRequest;
import com.soap.producer.errorHandler.MissingRentDataException;
import com.soap.producer.generated.Car;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {

    public GetCarDetailsRequest entityToDto(Car car) {
        GetCarDetailsRequest carDto = new GetCarDetailsRequest();
        carDto.setId(car.getId());
        carDto.setCustomerName(car.getCustomerName());
        carDto.setEndDate(car.getEndDate());
        carDto.setModel(carDto.getModel());

        return carDto;
    }

    public Car DtoToEntity(GetCarDetailsRequest carDto) {
        Car car = new Car();
        if (isEmpty(carDto)) {
            car.setId(carDto.getId());
            car.setCustomerName(carDto.getCustomerName());
            car.setEndDate(carDto.getEndDate());
            car.setModel(carDto.getModel());
        }
        return car;
    }

    public List<GetCarDetailsRequest> entityToDtoList(List<Car> cars) {
        return cars.stream().map(car -> entityToDto(car)).collect(Collectors.toList());
    }

    public List<Car> DtoToEntityList(List<GetCarDetailsRequest> carDtos) {
        return carDtos.stream().map(carDto -> DtoToEntity(carDto)).collect(Collectors.toList());
    }

    public boolean isEmpty(GetCarDetailsRequest dto) {
        if (dto.getId() <= 0 || dto.getCustomerName() == null || dto.getEndDate() == null) {
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
