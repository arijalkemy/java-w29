package com.bootcampw29.qa_testers.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;


import java.time.LocalDateTime;



@Getter
public class ErrorResponseDTO {
    private final LocalDateTime timestamp;
    private final String message;

    public ErrorResponseDTO(String message) {
        this.timestamp = LocalDateTime.now();
        this.message = message;
    }
}
