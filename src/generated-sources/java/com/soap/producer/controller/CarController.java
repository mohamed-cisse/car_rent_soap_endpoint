package com.soap.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soap.producer.converter.Converter;
import com.soap.producer.domain.CarDto;
import com.soap.producer.elasticsearch.searchrequest.ElasticDTO;
import com.soap.producer.elasticsearch.service.ElasticService;
import com.soap.producer.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CarController {

    private final Converter converter;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final CarService carService;
    private final ElasticService elasticService;
    private final ObjectMapper mapper;

    @Autowired
    public CarController(Converter converter, KafkaTemplate<String, String> kafkaTemplate, CarService carService, ElasticService elasticService, ObjectMapper mapper) {
        this.converter = converter;
        this.kafkaTemplate = kafkaTemplate;
        this.carService = carService;
        this.elasticService = elasticService;
        this.mapper = mapper;
    }

    @Autowired

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
    public CarDto rentCarRequest(@RequestBody CarDto dto, @AuthenticationPrincipal OAuth2User user) throws JsonProcessingException {

        CarDto carDto = converter.entityToDto(carService.rentCar(converter.DtoToEntity(dto, user)));

        kafkaTemplate.send("CarRenting", mapper.writeValueAsString(carDto));
        return carDto;

    }

    @PostMapping("/search")
    public List<String> search(@RequestBody final ElasticDTO dto) {
        return elasticService.autocomplete(dto);
    }

    @GetMapping("/me")
    public Map<String, Object> userDetails(@AuthenticationPrincipal OAuth2User user) {
        String name = user.getAttribute("name");

        return user.getAttributes();
    }


}
