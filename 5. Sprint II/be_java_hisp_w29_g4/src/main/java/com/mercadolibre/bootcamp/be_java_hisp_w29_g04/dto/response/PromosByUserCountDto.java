package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PromosByUserCountDto {

    private Integer userId;
    private String userName;
    private Integer promoProductsCount;
}
