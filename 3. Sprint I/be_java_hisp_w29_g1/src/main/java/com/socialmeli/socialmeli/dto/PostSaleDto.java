package com.socialmeli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public record PostSaleDto(
        @JsonProperty("user_id") Integer idUser,
        LocalDate date,
        ProductDto product,
        Integer category,
        Double price,
        @JsonProperty("has_promo") Boolean hasPromo,
        Double discount
) {}
