package com.bootcamp.be_java_hisp_w29_g07.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@Data
public class ValidationExceptionDTO {
    private LocalDate timestamp;
    private String message;
    private List<FieldErrorDetailDTO> errors;

    public ValidationExceptionDTO(String message, List<FieldErrorDetailDTO> errors) {
        this.timestamp = LocalDate.now();
        this.message = message;
        this.errors = errors;
    }
}
