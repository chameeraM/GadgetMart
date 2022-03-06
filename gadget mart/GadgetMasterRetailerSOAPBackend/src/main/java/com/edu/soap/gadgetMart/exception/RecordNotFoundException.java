package com.edu.soap.gadgetMart.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Class for exception when requested data is not available
 */
@Getter
@NoArgsConstructor
public class RecordNotFoundException extends BaseException {

    private final String message = "Requested data not available";
    private final HttpStatus status = HttpStatus.BAD_REQUEST;
    private final int code = ResponseCode.INVALID_INPUT;
    private String description;

    public RecordNotFoundException(String description) {
        this.description = description;
    }

}
