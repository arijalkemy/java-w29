package com.socialmeli.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RankingPostSellerDto(
        @JsonProperty("user_id") Integer idUser,
        @JsonProperty("user_name") String nameUser,
        @JsonProperty("post_count") Integer postCount
) {}
