package com.thiagoschreck.local.melisocial.dto.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ClientDTO(
        @JsonProperty("user_id")
        int userId,
        @JsonProperty("user_name")
        String userName,
        List<UserInfoDTO> followed
) {
}
