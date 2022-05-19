package com.roytuts.jaxb.producer.repository;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

import com.roytuts.jaxb.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.roytuts.jaxb.Car;

import javax.swing.text.DateFormatter;

import static java.time.LocalDate.parse;

@Component
public interface CarRepository extends JpaRepository<Car,Integer> {
}
