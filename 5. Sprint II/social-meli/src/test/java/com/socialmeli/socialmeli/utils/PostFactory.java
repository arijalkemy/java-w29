package com.socialmeli.socialmeli.utils;

import java.time.LocalDate;

import com.socialmeli.socialmeli.dto.PostDto;
import com.socialmeli.socialmeli.dto.PostSaleDto;
import com.socialmeli.socialmeli.dto.ProductDto;

public class PostFactory {

    public static ProductDto createProductDto(Integer id) {
        return ProductDto.builder()
                .id(id)
                .name("Product")
                .brand("Brand")
                .color("Color")
                .type("Type")
                .notes("Notes")
                .build();
    }

    public static PostDto createPostDto(Integer userId, Integer productId) {
        return PostDto.builder()
                .userId(userId)
                .date(LocalDate.now())
                .category(1)
                .price(100.0)
                .product(createProductDto(productId))
                .build();
    }

    public static PostSaleDto createPostSaleDto(Integer userId, Integer productId) {
        return PostSaleDto.builder()
                .idUser(userId)
                .date(LocalDate.now())
                .category(1)
                .price(100.0)
                .product(createProductDto(productId))
                .hasPromo(true)
                .discount(10.0)
                .build();
    }

    public static PostDto createPostIdDateDto(Integer userId, LocalDate date) {
        return PostDto.builder()
                .userId(userId)
                .date(date)
                .build();
    }
}
