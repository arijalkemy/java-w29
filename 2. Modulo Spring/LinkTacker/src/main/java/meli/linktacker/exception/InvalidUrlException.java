package meli.linktacker.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidUrlException extends RuntimeException{
    public InvalidUrlException(String message){
        super(message);
    }


}
