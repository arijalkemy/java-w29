package com.thiagoschreck.local.melisocial.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateUserResponseDTO(
        @JsonProperty("user_id") Integer userId,
        @JsonProperty("user_name") String userName
) {
}
