package com.soap.producer.errorhandler;

import lombok.Data;

@Data
public class MissingRentDataException extends RuntimeException {

    public MissingRentDataException() {
        super();
    }
}
