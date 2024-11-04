package com.workintech.s19d1.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleApiException(ApiException ex) {
        log.error("API Exception Occured: " + ex);
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), ex.getHttpStatus().value(), LocalDateTime.now()), ex.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> handleApiException(Exception ex) {
        log.error("Exception Occured: " + ex);
        return new ResponseEntity<>(new ExceptionResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
