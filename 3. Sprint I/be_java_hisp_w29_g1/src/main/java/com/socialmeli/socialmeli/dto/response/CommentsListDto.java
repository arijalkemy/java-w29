package com.socialmeli.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record CommentsListDto(
        @JsonProperty("post_id") Integer postId,
        List<CommentResponseDto> comments
) {}
