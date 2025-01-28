package com.socialmeli.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;

@JsonPropertyOrder({"user_id", "user_name"})
public record ProductsPromotionDto(
        @JsonProperty("user_id") Integer idUser,
        @JsonProperty("user_name") String nameUser,
        List<PostIdSaleDto> posts
) {}

