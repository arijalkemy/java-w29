package com.bootcampw29.qa_testers.dto.response;

import lombok.Getter;

import java.util.List;

@Getter
public class ValidationErrorResponseDTO extends ErrorResponseDTO{

    private final List<ValidationErrorDTO> errors;

    public ValidationErrorResponseDTO(String message, List<ValidationErrorDTO> errors) {
        super(message);
        this.errors = errors;
    }
}
