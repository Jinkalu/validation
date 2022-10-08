package com.validation.main.exception;

import com.validation.main.vo.ErrorVO;
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
   public ResponseEntity<Map<String,ErrorVO>> handleMethodArgsNotValidException(MethodArgumentNotValidException exception){
       Map<String, ErrorVO> errors=new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(error->{
            String fieldName=((FieldError)error).getField();
            ErrorVO errorVO =ErrorVO.builder()
                    .fieldName(fieldName)
                    .message(error.getDefaultMessage())
                    .build();
            errors.put(fieldName,errorVO);
        });
       return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
   }
}
