package com.example.showroom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SaleDetailDto {
    private ClotheDto clothe;

    private Integer quantity;

    private Double subtotal;
}
