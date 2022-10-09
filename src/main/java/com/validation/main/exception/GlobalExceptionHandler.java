package com.validation.main.exception;

import com.validation.main.vo.ApiException;
import com.validation.main.vo.ErrorVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorVO> handleMethodArgsNotValidException(MethodArgumentNotValidException exception) {
        List<ErrorVO> errors;
        errors = exception.getBindingResult().getAllErrors().stream().map(objectError ->
                        ErrorVO.builder()
                                .fieldName(((FieldError) objectError).getField())
                                .message(List.of(Objects.requireNonNull(objectError.getDefaultMessage())))
                                .build())
                .collect(Collectors.toList());
        return new ResponseEntity<>(errors.get(0), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {ApiExceptionHandler.class})
    public ResponseEntity<Object> handleApiRequestException(ApiExceptionHandler e){
        ApiException apiException= ApiException.builder()
                .message(List.of(e.getMessage()))
                .build();
        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
}
