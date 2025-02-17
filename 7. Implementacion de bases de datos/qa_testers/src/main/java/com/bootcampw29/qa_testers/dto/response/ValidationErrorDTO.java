package com.bootcampw29.qa_testers.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ValidationErrorDTO {
    private String field;
    private String message;
}
