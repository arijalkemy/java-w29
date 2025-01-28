package com.socialmeli.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record ProductListDto(
        @JsonProperty("user_id") Integer id,
        List<PostIdDto> posts
) {}

