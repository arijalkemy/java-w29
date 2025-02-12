package com.bootcamp.be_java_hisp_w29_g07.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldErrorDetailDTO {
    private String field;
    private String message;
}
