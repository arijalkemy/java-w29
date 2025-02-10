package org.melibootcamp.qatester.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MessajeDto {
    private String message;

    public MessajeDto(String message) {
        this.message = message;
    }
}
