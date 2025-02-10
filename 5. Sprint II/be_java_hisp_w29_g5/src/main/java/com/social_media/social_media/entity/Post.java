package com.social_media.social_media.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private Long postId;
    private Long userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonDeserialize(using =LocalDateDeserializer.class)
    private LocalDate date;
    private Product product;
    private Integer category;
    private Double price;
    private Double discount;
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonDeserialize(using =LocalDateDeserializer.class)
    private LocalDate promotionEndDate;
}
