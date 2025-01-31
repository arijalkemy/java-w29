package com.thiagoschreck.local.melisocial.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateUserRequestDTO(@JsonProperty("user_name") String userName) {
}
