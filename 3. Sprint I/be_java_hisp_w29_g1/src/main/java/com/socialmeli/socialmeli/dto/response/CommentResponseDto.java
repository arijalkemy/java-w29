package com.socialmeli.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CommentResponseDto(
        @JsonProperty("user_id") Integer userId,
        @JsonProperty("user_name") String userName,
        String content
) {}
