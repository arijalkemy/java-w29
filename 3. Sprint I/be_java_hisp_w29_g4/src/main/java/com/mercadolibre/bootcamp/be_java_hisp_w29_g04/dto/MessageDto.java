package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDto {
    String message;

    public MessageDto(String message) {
        this.message = message;
    }
}
