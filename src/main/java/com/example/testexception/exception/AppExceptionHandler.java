package com.example.testexception.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.LocalTime;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AccountNotFound.class)
    public ResponseEntity<Object>  handleAccountNotFound(AccountNotFound ex, WebRequest request){

        return new ResponseEntity<>(new ApiError(ex.getMessage(), ex.getMessage(), ex.getMessage()), HttpStatus.NOT_FOUND);
    }



}
