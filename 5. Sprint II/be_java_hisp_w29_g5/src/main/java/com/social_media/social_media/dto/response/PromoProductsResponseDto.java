package com.social_media.social_media.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PromoProductsResponseDto {
    private Long user_id;
    private String user_name;
    private Integer promo_products_count;
}
