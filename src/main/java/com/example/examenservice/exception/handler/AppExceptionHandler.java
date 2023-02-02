package com.example.examenservice.exception.handler;

import com.example.examenservice.exception.AppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(value = AppException.class)
    private ResponseEntity<Object> handleException(AppException appException){
        return new ResponseEntity<>(appException.getMessage(),appException.getStatus());
    }
}
