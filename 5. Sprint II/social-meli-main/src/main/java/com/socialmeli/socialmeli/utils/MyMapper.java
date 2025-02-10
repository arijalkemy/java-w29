package com.socialmeli.socialmeli.utils;

import com.socialmeli.socialmeli.dto.PostDto;
import com.socialmeli.socialmeli.dto.PostSaleDto;
import com.socialmeli.socialmeli.dto.ProductDto;
import com.socialmeli.socialmeli.dto.response.PostIdDto;
import com.socialmeli.socialmeli.dto.response.UserDto;
import com.socialmeli.socialmeli.models.Post;
import com.socialmeli.socialmeli.models.Product;
import com.socialmeli.socialmeli.models.User;

public class MyMapper {
    public static UserDto toUserDto(User user) {
        return new UserDto(user.getId(), user.getName());
    }

    public static PostIdDto toPostIdDto(Post post) {
        return PostIdDto.builder()
                .userId(post.getUser().getId())
                .id(post.getId())
                .date(post.getDate())
                .product(toProductDto(post.getProduct()))
                .category(post.getCategory())
                .price(post.getPrice())
                .build();
    }

    public static Post toPost(User user, PostDto postDto) {
        return Post.builder()
                .user(user)
                .date(postDto.getDate())
                .price(postDto.getPrice())
                .product(toProduct(postDto.getProduct()))
                .category(postDto.getCategory())
                .build();
    }

    public static Post toPost(User user, PostSaleDto postDto) {
        return Post.builder()
                .user(user)
                .date(postDto.getDate())
                .discount(postDto.getDiscount())
                .hasPromo(postDto.getHasPromo())
                .price(postDto.getPrice())
                .category(postDto.getCategory())
                .product(toProduct(postDto.getProduct()))
                .build();
    }

    public static Product toProduct(ProductDto productDto) {
        return Product.builder()
                .id(productDto.getId())
                .color(productDto.getColor())
                .name(productDto.getName())
                .notes(productDto.getNotes())
                .type(productDto.getType())
                .brand(productDto.getBrand())
                .build();
    }

    public static ProductDto toProductDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .brand(product.getBrand())
                .color(product.getColor())
                .name(product.getName())
                .notes(product.getNotes())
                .type(product.getType())
                .build();
    }
}
