package com.meli.obtenerdiploma.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ErrorDTO {
    private String message;
    private Map<String, String> errors;
    private int statusCode;
}
