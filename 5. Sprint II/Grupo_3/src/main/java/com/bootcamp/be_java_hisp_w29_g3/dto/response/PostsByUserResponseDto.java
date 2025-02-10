package com.bootcamp.be_java_hisp_w29_g3.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PostsByUserResponseDto {
    private Integer userId;
    private List<PostByUserDto> posts;
}
