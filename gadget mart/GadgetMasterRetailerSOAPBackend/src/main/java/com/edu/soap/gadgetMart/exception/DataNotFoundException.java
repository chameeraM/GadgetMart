package com.edu.soap.gadgetMart.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;



@Getter
public class DataNotFoundException extends BaseException {

    private static final String MESSAGE = "Missing data ";
    private static final HttpStatus STATUS = HttpStatus.BAD_REQUEST;
    private static final int CODE = ResponseCode.INVALID_INPUT;

    public DataNotFoundException() {
        super(MESSAGE,"",STATUS,CODE);
    }

    public DataNotFoundException(String description) {
        super(MESSAGE,description,STATUS,CODE);
    }
}
