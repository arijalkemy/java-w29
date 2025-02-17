package com.social_media.social_media.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PostPromoEndDateResponseDto {
    private Long post_id;
    private Long user_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductResponseDto product;
    private Integer category;
    private Double price;
    private Boolean has_promo;
    private Double discount;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate promotionEndDate;
}
