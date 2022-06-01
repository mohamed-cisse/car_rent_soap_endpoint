package com.soap.producer.controller;

import com.soap.producer.converter.Converter;
import com.soap.producer.domain.CarDto;
import com.soap.producer.domain.CarElasticSearch;
import com.soap.producer.service.CarService;
import com.soap.producer.service.ElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CarController {

    Converter converter;

    private CarService carService;
    private ElasticService elasticService;
    @Autowired
    public CarController(Converter converter, CarService carService, ElasticService elasticService) {
        this.converter = converter;
        this.carService = carService;
        this.elasticService = elasticService;
    }
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
    @PostMapping("/add")
    public CarElasticSearch save(@RequestBody CarElasticSearch car)
    {
        return elasticService.save(car);
    }

    @GetMapping("/me")
    public Map<String, Object> userDetails(@AuthenticationPrincipal OAuth2User user) {
       String name= user.getAttribute("name");

        return user.getAttributes();
    }


}
