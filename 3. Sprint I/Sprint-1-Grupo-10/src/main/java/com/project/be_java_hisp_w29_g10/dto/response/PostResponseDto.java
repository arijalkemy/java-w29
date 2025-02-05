package com.project.be_java_hisp_w29_g10.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostResponseDto {
    private Long user_id;
    private Long post_id;
    private String date;
    private ProductResponseDto product;
    private Integer category;
    private Double price;
}


