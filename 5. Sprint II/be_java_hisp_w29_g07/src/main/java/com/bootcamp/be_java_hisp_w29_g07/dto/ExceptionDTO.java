package com.bootcamp.be_java_hisp_w29_g07.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the response of an exception
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExceptionDTO {
    /**
     * Message to respond
     */
    private String message;
}
