package com.example.showroom.dto.request;

import lombok.*;

@Getter  @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClotheRequestDto {
    private String code, name, type, brand, color, size;
    private Integer quantity;
    private double priceSale;
}
