package com.socialmeli.socialmeli.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.socialmeli.socialmeli.dto.request.CommentRequestDto;
import com.socialmeli.socialmeli.dto.response.CommentResponseDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"user_id"})
public class PostDto {
    @JsonProperty("user_id")
    private Integer userId;

    private LocalDate date;

    private ProductDto product;

    private Integer category;

    private Double price;

    private List<CommentResponseDto> comments;
}
