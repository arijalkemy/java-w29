package com.socialmeli.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDto(
        @JsonProperty("user_id") Integer id,
        @JsonProperty("user_name") String name
) {}
