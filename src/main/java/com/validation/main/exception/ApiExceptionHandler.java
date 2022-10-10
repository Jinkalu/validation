package com.validation.main.exception;

import lombok.Data;

@Data
public class ApiExceptionHandler extends RuntimeException{

   private final String code;
   private final String message;

   public ApiExceptionHandler(String code,String message) {
      super();
      this.code=code;
      this.message=message;
   }



}
