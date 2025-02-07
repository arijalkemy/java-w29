package com.app.dto.response;

import com.app.dto.request.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class PostsWithProductDTO {
    private final Integer user_id;
    private final Integer post_id;
    private final LocalDate date;
    private final ProductDTO product;
    private final Integer category;
    private final Double price;
    private final boolean has_promo;
    private final Double discount;
}
