package com.soap.producer.converter;

import com.soap.producer.errorhandler.MissingRentDataException;
import com.soap.producer.domain.Car;
import com.soap.producer.domain.CarDto;
import org.springframework.security.oauth2.core.AbstractOAuth2Token;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {

    public CarDto entityToDto(Car car) {

        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setModel(car.getModel());
        carDto.setCustomerName(car.getCustomerName());
        carDto.setEndDate(car.getEndDate());
        carDto.setModel(car.getModel());
        carDto.setCustomerEmail(car.getCustomerEmail());

        return carDto;
    }

    public Car DtoToEntity(CarDto carDto, OAuth2User user) {

        Car car = new Car();
        if (isEmpty(carDto, user)) {
            car.setId(carDto.getId());
            car.setCustomerName(user.getAttribute("name"));
            car.setEndDate(carDto.getEndDate());
            car.setCustomerEmail(user.getAttribute("email"));
            car.setModel(carDto.getModel());
        } else throw new MissingRentDataException();
        return car;
    }

    public List<CarDto> entityToDtoList(List<Car> cars) {
        return cars.stream().map(car -> entityToDto(car)).collect(Collectors.toList());
    }

//    public List<Car> DtoToEntityList(List<CarDto> carDtos) {
//        return carDtos.stream().map(carDto -> DtoToEntity(carDto)).collect(Collectors.toList());
//    }

    public boolean isEmpty(CarDto dto, OAuth2User user) {
        if (dto.getId() <= 0 || user.getAttribute("name").equals(null) || user.getAttribute("email").equals(null) || dto.getEndDate() == null) {
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
