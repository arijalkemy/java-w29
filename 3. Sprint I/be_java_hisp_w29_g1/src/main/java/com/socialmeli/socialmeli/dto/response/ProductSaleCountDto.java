package com.socialmeli.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductSaleCountDto(
        @JsonProperty("user_id") Integer id,
        @JsonProperty("user_name") String name,
        @JsonProperty("promo_products_count") Integer promoProductsCount
) {}
