package com.workintech.s19d1.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@AllArgsConstructor
@Data
@ResponseStatus
public class ApiException extends RuntimeException{
    private final HttpStatus httpStatus;
    public ApiException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }


}
