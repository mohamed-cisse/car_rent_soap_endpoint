package com.soap.producer.repository;

import com.soap.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static java.time.LocalDate.parse;

@Component
public interface CarRepository extends JpaRepository<Car,Integer> {

    List<Car> getCarByEndDateNullOrEndDateIsBefore(Date now);

}