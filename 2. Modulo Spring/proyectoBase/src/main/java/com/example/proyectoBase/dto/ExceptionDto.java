package com.example.proyectoBase.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ExceptionDto {
    private String message;

    public ExceptionDto(String message) {
        this.message = message;
    }
}