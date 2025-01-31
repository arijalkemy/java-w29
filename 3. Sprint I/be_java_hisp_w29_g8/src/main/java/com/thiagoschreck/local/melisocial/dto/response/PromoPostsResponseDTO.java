package com.thiagoschreck.local.melisocial.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.thiagoschreck.local.melisocial.dto.PostDTO;

import java.util.List;

public record PromoPostsResponseDTO(
        @JsonProperty("user_id") int userId,
        @JsonProperty("user_name") String userName,
        List<PostDTO> posts
) {
}
