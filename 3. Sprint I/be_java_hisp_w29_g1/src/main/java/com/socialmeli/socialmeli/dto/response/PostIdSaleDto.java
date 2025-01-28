package com.socialmeli.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.socialmeli.socialmeli.dto.ProductDto;

import java.time.LocalDate;

@JsonPropertyOrder({"user_id", "post_id", "date", "product", "category", "price", "hasPromo", "discount"})
public record PostIdSaleDto(
        @JsonProperty("user_id") Integer userId,
        @JsonProperty("post_id") Integer id,
        LocalDate date,
        ProductDto product,
        Integer category,
        Double price,
        @JsonProperty("has_promo") Boolean hasPromo,
        Double discount
) {}

