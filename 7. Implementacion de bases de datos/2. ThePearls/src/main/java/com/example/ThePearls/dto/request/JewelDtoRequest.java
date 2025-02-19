package com.example.ThePearls.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class JewelDtoRequest {
    private String name;
    private String material;
    private Double weight;
    private String particularity;
    private Boolean ownStone;
}
