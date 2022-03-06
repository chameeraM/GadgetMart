package com.edu.soap.gadgetMart.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ErrorDetail {
    private Date timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public ErrorDetail(Date timestamp, Integer status,String error, String message, String path) {
        this.timestamp = timestamp;
        this.status=status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    public ErrorDetail(BaseException ex, WebRequest request) {
        this.timestamp=new Date();
        this.status=ex.getCode();
        this.error=ex.getDescription();
        this.message=ex.getMessage();
        this.path=((ServletWebRequest)request).getRequest().getRequestURI();
    }
}
