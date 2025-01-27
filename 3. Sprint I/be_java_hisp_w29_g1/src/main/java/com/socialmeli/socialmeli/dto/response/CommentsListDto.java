package com.socialmeli.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CommentsListDto {
    @JsonProperty("post_id")
    private Integer postId;

    private List<CommentResponseDto> comments;
}
