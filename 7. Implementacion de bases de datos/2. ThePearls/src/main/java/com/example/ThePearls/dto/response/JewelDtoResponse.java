package com.example.ThePearls.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JewelDtoResponse {
    private Long id_number;
    private String name;
    private String material;
    private Double weight;
    private String particularity;
    private Boolean ownStone;
    private Boolean saleOrNot;
}
