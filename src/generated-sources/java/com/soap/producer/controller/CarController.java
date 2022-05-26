package com.soap.producer.controller;

import com.soap.producer.converter.Converter;
import com.soap.producer.domain.CarDto;
import com.soap.producer.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CarController {
    @Autowired
    Converter converter;
    @Autowired
    private CarService carService;
   // private static final Logger logger = LoggerFactory.getLogger(CarController.class);

//    @RequestMapping("/")
//    public ModelAndView getRequest() {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("index");
//        return modelAndView;
//
//    }
    @RequestMapping("/cars")
    public List<CarDto> getCarsRequest() {

        return converter.entityToDtoList(carService.getCars());
    }

    @PostMapping("/rent")
    public CarDto rentCarRequest(@RequestBody CarDto dto,@AuthenticationPrincipal OAuth2User user) {

        return converter.entityToDto(carService.rentCar(converter.DtoToEntity(dto,user)));

    }

    @GetMapping("/me")
    public Map<String, Object> userDetails(@AuthenticationPrincipal OAuth2User user) {
       String name= user.getAttribute("name");

        return user.getAttributes();
    }


}
