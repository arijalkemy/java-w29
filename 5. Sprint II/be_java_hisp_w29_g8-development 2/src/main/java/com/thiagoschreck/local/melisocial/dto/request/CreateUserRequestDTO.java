package com.thiagoschreck.local.melisocial.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;

public record CreateUserRequestDTO(
        @NotEmpty(message = "Username can not be null or empty")
        @JsonProperty("user_name")
        String userName
) {
}
