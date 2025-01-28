package com.socialmeli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProductDto(
        @JsonProperty("product_id") Integer id,
        @JsonProperty("product_name") String name,
        String type,
        String brand,
        String color,
        String notes
) {}
