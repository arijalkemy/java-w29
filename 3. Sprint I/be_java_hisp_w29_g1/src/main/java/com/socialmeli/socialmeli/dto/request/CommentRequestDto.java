package com.socialmeli.socialmeli.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"user_id"})
public class CommentRequestDto {
    @JsonProperty("user_id")
    private Integer userId;

    private String content;
}