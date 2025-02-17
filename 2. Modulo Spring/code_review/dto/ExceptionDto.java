package org.example.code_review.dto;

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
