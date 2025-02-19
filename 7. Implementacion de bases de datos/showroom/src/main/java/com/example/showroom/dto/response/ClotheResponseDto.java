package com.example.showroom.dto.response;

import lombok.*;

@Getter @Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClotheResponseDto {
    private Long id;
    private String code, name, type, brand, color, size;
    private Integer quantity;
    private double priceSale;
}
