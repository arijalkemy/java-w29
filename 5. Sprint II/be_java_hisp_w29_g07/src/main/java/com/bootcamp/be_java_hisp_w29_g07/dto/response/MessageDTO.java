package com.bootcamp.be_java_hisp_w29_g07.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a message in a response
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {
    /**
     * Message to respond
     */
    private String message;
}
