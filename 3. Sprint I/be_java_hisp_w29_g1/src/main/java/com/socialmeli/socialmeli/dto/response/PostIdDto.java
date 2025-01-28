package com.socialmeli.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.socialmeli.socialmeli.dto.ProductDto;

import java.time.LocalDate;

public record PostIdDto(
        @JsonProperty("user_id") Integer userId,
        @JsonProperty("post_id") Integer id,
        LocalDate date,
        ProductDto product,
        Integer category,
        Double price
) {}

