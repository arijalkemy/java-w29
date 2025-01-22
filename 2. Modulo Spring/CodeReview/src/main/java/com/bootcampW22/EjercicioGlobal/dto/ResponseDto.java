package com.bootcampW22.EjercicioGlobal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ResponseDto {
    private String message;

    public ResponseDto(String message) {
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
