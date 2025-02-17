package com.bootcampw29.jewelry.dto.response;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class JewelResponseDTO {
    private Long id;
    private String name;
    private String material;
    private Double weightInG;
    private String particularity;
    private Boolean hasStone;
    private Boolean isForSale;
}
