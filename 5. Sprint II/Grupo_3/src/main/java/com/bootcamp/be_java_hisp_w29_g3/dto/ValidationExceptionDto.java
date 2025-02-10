package com.bootcamp.be_java_hisp_w29_g3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ValidationExceptionDto {
    private Map<String, String> errors;
}
