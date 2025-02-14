package com.meli.socialmeli.dto.response;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.socialmeli.dto.PostDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@EqualsAndHashCode
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostFromFollowedDto {
    @JsonProperty("user_id")
    private Integer userId;
    private List<PostDto> posts;
}
