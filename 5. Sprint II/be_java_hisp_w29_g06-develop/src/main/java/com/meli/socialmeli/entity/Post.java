package com.meli.socialmeli.entity;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private Integer id;
    private LocalDate date;
    private Double price;
    private Product product;
    private Seller seller;
    private Double discount;
    private Boolean hasPromo;
    private Integer category;
}
