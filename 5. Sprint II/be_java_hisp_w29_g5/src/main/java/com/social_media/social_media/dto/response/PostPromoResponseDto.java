package com.social_media.social_media.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class PostPromoResponseDto {
    private Long post_id;
    private Long user_id;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductResponseDto product;
    private Integer category;
    private Double price;
    private Boolean has_promo;
    private Double discount;
}
