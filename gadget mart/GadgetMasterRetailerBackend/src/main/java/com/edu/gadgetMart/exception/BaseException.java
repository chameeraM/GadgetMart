package com.edu.gadgetMart.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.http.HttpStatus;

/**
 * Exception class for mandatory data in error response
 *
 * @since 06/19
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BaseException extends RuntimeException{

    private String message;
    private String description;
    @JsonIgnore
    private HttpStatus status;
    private int code;
}
