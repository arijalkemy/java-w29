package org.example.code_review.exception;


public class VehicleAlreadyExistsException extends RuntimeException{
    public VehicleAlreadyExistsException(String msg){
        super(msg);
    }

}
