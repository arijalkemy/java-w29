package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@NoArgsConstructor
@Data
public class PromoPostDto extends PostDto{
    private Boolean hasPromo;
    private Double discount;

    public PromoPostDto(Integer userId, LocalDate createdAt, ProductDto product, Integer category, Double price, Boolean hasPromo, Double discount) {
        super(userId, createdAt, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
