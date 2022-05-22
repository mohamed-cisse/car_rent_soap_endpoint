package com.soap.producer.errorHandler;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data

public class CarNotFoundexption extends RuntimeException {
    public CarNotFoundexption() {
        super();
    }
}
