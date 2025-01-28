package com.socialmeli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.socialmeli.socialmeli.dto.response.CommentResponseDto;

import java.time.LocalDate;
import java.util.List;

public record PostDto(
        @JsonProperty("user_id") Integer userId,
        LocalDate date,
        ProductDto product,
        Integer category,
        Double price,
        List<CommentResponseDto> comments
) {}

