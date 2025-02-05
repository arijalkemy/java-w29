package com.bootcamp.be_java_hisp_w29_g3.util;

import com.bootcamp.be_java_hisp_w29_g3.dto.ProductDto;
import com.bootcamp.be_java_hisp_w29_g3.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w29_g3.dto.response.*;
import com.bootcamp.be_java_hisp_w29_g3.entity.Post;
import com.bootcamp.be_java_hisp_w29_g3.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class MapperUtil {
    private static final ObjectMapper mapper = JacksonUtil.createObjectMapper();

    public static Post mapToPost(PostRequestDto postDto){
        return mapper.convertValue(postDto, Post.class);
    }

    public static PostResponseDto mapToFullPostResponseDto(Post post) {
        FullPostResponseDto response = mapper.convertValue(post, FullPostResponseDto.class);
        response.setPostId(post.getId());
        return response;
    }

    public static List<PostDto> buildPostDto(List<Post> post){
        return post.stream().map(p -> mapper.convertValue(p,PostDto.class)).toList();
    }

    public static PostResponseDto mapToBasicPostResponseDto(Post post) {
        BasicPostResponseDto response = mapper.convertValue(post, BasicPostResponseDto.class);
        response.setPostId(post.getId());
        return response;
    }

    public static List<PostByUserDto> mapToPostByUserResponseDto(List<Post> posts, Integer userId) {
        List<PostByUserDto> dtos = new ArrayList<>();
        posts.forEach(post -> {
            dtos.add(buildPostByUserDto(post, userId));
        });
        return dtos;
    }

    private static PostByUserDto buildPostByUserDto(Post post, Integer userId){
        PostByUserDto dto = new PostByUserDto();
        dto.setUserId(userId);
        dto.setPostId(post.getId());
        dto.setProduct(buildProductDto(post.getProduct()));
        dto.setDate(post.getDate());
        dto.setPrice(post.getPrice());
        dto.setCategory(post.getCategory());
        return dto;
    }

    private static ProductDto buildProductDto(Product product){
        ProductDto dto = new ProductDto();
        dto.setProductId(product.getId());
        dto.setProductName(product.getName());
        dto.setType(product.getType());
        dto.setNotes(product.getNotes());
        dto.setColor(product.getColor());
        dto.setBrand(product.getBrand());
        return dto;
    }
}

