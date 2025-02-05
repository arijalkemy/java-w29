package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.exception;

public class BadRequestException extends RuntimeException{
   public BadRequestException(String message){
      super(message);}
}
