package com.socialmeli.socialmeli.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private Integer id;

    private User user;

    private LocalDate date;

    private Product product;

    private Integer category;

    private Double price;

    @Builder.Default
    private Boolean hasPromo = false;

    private Double discount;

    private List<Comment> comments;
}
