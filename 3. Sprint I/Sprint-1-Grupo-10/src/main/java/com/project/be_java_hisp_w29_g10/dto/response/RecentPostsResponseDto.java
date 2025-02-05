package com.project.be_java_hisp_w29_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RecentPostsResponseDto {
    private Long user_id;
    private List<PostResponseDto> posts;
}
