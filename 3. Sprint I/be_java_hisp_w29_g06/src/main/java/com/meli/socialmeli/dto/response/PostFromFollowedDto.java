package com.meli.socialmeli.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.socialmeli.dto.PostDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class PostFromFollowedDto {
    @JsonProperty("user_id")
    private Integer userId;
    private List<PostDto> posts;
}