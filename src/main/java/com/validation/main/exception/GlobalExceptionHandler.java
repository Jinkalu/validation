package com.validation.main.exception;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<Map<String,String>> handleMethodArgsNotValidException(MethodArgumentNotValidException exception){
       Map<String,String> errors=new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(error->{
            String fieldName=((FieldError)error).getField();
            String message =error.getDefaultMessage();
            errors.put(fieldName,message);
        });
       return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
   }
}