package com.validation.main.exception;

public class ApiExceptionHandler extends RuntimeException{

    public ApiExceptionHandler(String message) {
        super(message);
    }
    public ApiExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }
}
