package com.fawry.user_api.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ApiExceptionHandler> handleAccountNotFound(UserException ex) {

        HttpStatus status = HttpStatus.NOT_FOUND;
        ApiExceptionHandler apiException=new ApiExceptionHandler(
                ex.getMessage(),
                status,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiException, status);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiExceptionHandler> handleGenericException(Exception ex) {

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiExceptionHandler apiException=new ApiExceptionHandler(
                ex.getMessage(),
                status,
                LocalDateTime.now()
        );
        return new ResponseEntity<>(apiException, status);
    }
}