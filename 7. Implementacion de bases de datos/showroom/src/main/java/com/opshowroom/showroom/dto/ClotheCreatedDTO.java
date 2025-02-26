package com.opshowroom.showroom.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ClotheCreatedDTO {
    private MessageDTO message;
    private Long clotheId;
}
