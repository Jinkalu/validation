package com.validation.main.exception;


public class ApiExceptionHandler extends RuntimeException{

   private final String code;
   private final String message;

   public ApiExceptionHandler(String code,String message) {
      super();
      this.code=code;
      this.message=message;
   }

   public String getCode() {
      return code;
   }

   @Override
   public String getMessage() {
      return message;
   }
}
