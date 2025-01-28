package com.socialmeli.socialmeli.utils;

import com.socialmeli.socialmeli.dto.PostDto;
import com.socialmeli.socialmeli.dto.PostSaleDto;
import com.socialmeli.socialmeli.dto.ProductDto;
import com.socialmeli.socialmeli.dto.response.CommentResponseDto;
import com.socialmeli.socialmeli.dto.response.PostIdDto;
import com.socialmeli.socialmeli.dto.response.PostIdSaleDto;
import com.socialmeli.socialmeli.dto.response.UserDto;
import com.socialmeli.socialmeli.models.Comment;
import com.socialmeli.socialmeli.models.Post;
import com.socialmeli.socialmeli.models.Product;
import com.socialmeli.socialmeli.models.User;

public class MyMapper {
    public static UserDto toUserDto(User user) {
        return new UserDto(user.getId(), user.getName());
    }

    public static CommentResponseDto toCommentResponseDto(Comment comment) {
        return new CommentResponseDto(comment.getUser().getId(), comment.getUser().getName(), comment.getContent());
    }

    public static PostIdDto toPostIdDto(Post post) {
        return new PostIdDto(
                post.getUser().getId(),
                post.getId(),
                post.getDate(),
                toProductDto(post.getProduct()),
                post.getCategory(),
                post.getPrice()
        );
    }

    public static Post toPost(User user, PostDto postDto) {
        return Post.builder()
                .user(user)
                .date(postDto.date())
                .product(toProduct(postDto.product()))
                .category(postDto.category())
                .price(postDto.price())
                .build();
    }

    public static Post toPost(User user, PostSaleDto postDto) {
        return Post.builder()
                .user(user)
                .date(postDto.date())
                .discount(postDto.discount())
                .hasPromo(postDto.hasPromo())
                .price(postDto.price())
                .category(postDto.category())
                .product(toProduct(postDto.product()))
                .build();
    }

    public static Product toProduct(ProductDto productDto) {
        return Product.builder()
                .id(productDto.id())
                .color(productDto.color())
                .name(productDto.name())
                .notes(productDto.notes())
                .type(productDto.type())
                .brand(productDto.brand())
                .build();
    }

    public static ProductDto toProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getType(),
                product.getBrand(),
                product.getColor(),
                product.getNotes()
        );
    }

    public static PostIdSaleDto toPostIdSaleDto(Post post) {
        return new PostIdSaleDto(
                post.getUser().getId(),
                post.getId(),
                post.getDate(),
                toProductDto(post.getProduct()),
                post.getCategory(),
                post.getPrice(),
                post.getHasPromo(),
                post.getDiscount()
        );
    }
}