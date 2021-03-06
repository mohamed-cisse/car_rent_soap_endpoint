package com.soap.producer.errorhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CarNotFoundexption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNoRecordFoundException(CarNotFoundexption ex) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Failed No Record Found");
        return errorResponse;
    }

    @ExceptionHandler(CarRentedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleCarRentedException(CarRentedException ex) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Failed car already rented in that date");
        return errorResponse;
    }

    @ExceptionHandler(MissingRentDataException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleMissingRentDetailsException(MissingRentDataException ex) {

        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Failed missing rent data ");
        return errorResponse;
    }
}