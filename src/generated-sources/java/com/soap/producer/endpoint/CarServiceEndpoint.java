package com.soap.producer.endpoint;

import com.soap.producer.converter.Converter;
import com.soap.producer.domain.CarDto;
import com.soap.producer.domain.GetCarDetailsResponse;
import com.soap.producer.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CarServiceEndpoint {

    private final String NAMESPACE = "https://www.roytuts.com/UserService";

    @Autowired
    private CarService carService;
    @Autowired
    private Converter converter;


    @PayloadRoot(namespace = "https://www.roytuts.com/UserService", localPart = "getCarDetailsRequest")
    @ResponsePayload
    public GetCarDetailsResponse getCar(@RequestPayload final CarDto dto) {
        GetCarDetailsResponse response = new GetCarDetailsResponse();
        return mapRequest(response, dto);
    }

    public boolean isRent(CarDto dto) {
        return dto.getCustomerName() != null || dto.getEndDate() != null;
    }

    public GetCarDetailsResponse mapRequest(GetCarDetailsResponse response, CarDto dto) {

        if (isRent(dto)) {
            response.getCars().add(carService.rentCar(converter.DtoToEntity(dto, getOAuth2User())));

        } else {

            response.getCars().addAll(carService.getCars());
        }
        return response;
    }

    public OAuth2User getOAuth2User() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return (OAuth2User) authentication.getPrincipal();
    }


}
