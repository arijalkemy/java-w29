package com.social_media.social_media.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SellersPostsByFollowerResponseDto {
    private Long user_id;
    private List<PostResponseDto> posts;
}
