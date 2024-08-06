package com.fawry.user_api.Exceptions;

import com.fawry.user_api.Exceptions.customExceptions.NotAuthToSeeResourseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

import java.sql.Timestamp;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ApiExceptionHandler> UserException (
            UserException userException) {
        ApiExceptionHandler responseError = new
                ApiExceptionHandler(userException.getMessage(), HttpStatus.UNAUTHORIZED, LocalDateTime.now());

        return new ResponseEntity<>(responseError, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler
    public ResponseEntity<ApiExceptionHandler> handleNotAuthorizedException(
            NotAuthToSeeResourseException notAuthToSeeResourseException) {
        ApiExceptionHandler responseError = new
                ApiExceptionHandler(notAuthToSeeResourseException.getMessage(), HttpStatus.UNAUTHORIZED, LocalDateTime.now());

        return new ResponseEntity<>(responseError, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler
    public ResponseEntity<ApiExceptionHandler> handleGlobalException(Exception exception) {
        ApiExceptionHandler error =new ApiExceptionHandler(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now());

        return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}