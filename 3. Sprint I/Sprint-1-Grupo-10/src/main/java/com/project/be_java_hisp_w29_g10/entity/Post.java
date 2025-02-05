package com.project.be_java_hisp_w29_g10.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    private Long post_id;
    private Long user_id;
    private LocalDate date;
    private Long product_id;
    private Integer category;
    private Double price;
    private Boolean has_promo;
    private Double discount;
}
