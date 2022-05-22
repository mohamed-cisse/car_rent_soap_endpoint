package com.soap.producer.endpoint;

import com.soap.producer.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.soap.GetCarDetailsRequest;
import com.soap.GetCarDetailsResponse;

@Endpoint
public class CarServiceEndpoint {

	private final String NAMESPACE = "https://www.roytuts.com/UserService";

	@Autowired
	private CarService carService;

	@PayloadRoot(namespace = "https://www.roytuts.com/UserService", localPart = "getCarDetailsRequest")
	@ResponsePayload
	public GetCarDetailsResponse getCar(@RequestPayload final GetCarDetailsRequest request) {
		GetCarDetailsResponse response = new GetCarDetailsResponse();
		if(request.getEndDate()!=null&& request.getCustomerName()!=null&& request.getId()!=null) {

			response.getCars().add(carService.rentCar(request.getId(), request.getCustomerName(), request.getEndDate()));

		}else {

			response.getCars().addAll(carService.getCars());
		}
		return response;
	}



}
