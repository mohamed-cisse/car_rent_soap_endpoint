package com.soap.producer.errorhandler;

import lombok.Data;

@Data

public class CarNotFoundexption extends RuntimeException {
    public CarNotFoundexption() {
        super();
    }
}
