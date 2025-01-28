package com.socialmeli.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record FollowerListDto(
        @JsonProperty("user_id") Integer id,
        @JsonProperty("user_name") String name,
        List<UserDto> followers
) {}
