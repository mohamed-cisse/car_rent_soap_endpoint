package com.soap.producer.producer.repository;

import com.soap.producer.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import static java.time.LocalDate.parse;

@Component
public interface CarRepository extends JpaRepository<Car,Integer> {
}
