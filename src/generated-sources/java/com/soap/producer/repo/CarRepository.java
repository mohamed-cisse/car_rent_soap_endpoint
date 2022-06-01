package com.soap.producer.repo;

import com.soap.producer.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {

    List<Car> getCarByEndDateNullOrEndDateIsBefore(Date now);

}
