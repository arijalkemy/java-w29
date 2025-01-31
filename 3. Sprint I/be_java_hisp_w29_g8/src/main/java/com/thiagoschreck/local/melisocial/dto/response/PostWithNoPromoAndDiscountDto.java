package com.thiagoschreck.local.melisocial.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record PostWithNoPromoAndDiscountDto(
        int userId,
        @JsonProperty("post_id") int postId,
        LocalDate date,
        @JsonProperty("product_id") Integer productId,
        @JsonProperty("product_name") String productName,
        String type,
        String brand,
        String color,
        String notes,
        int category,
        double price
) {

}
