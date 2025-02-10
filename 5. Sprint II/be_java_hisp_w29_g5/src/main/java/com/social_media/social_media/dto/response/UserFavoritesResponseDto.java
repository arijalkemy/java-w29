package com.social_media.social_media.dto.response;

import lombok.*;

import java.util.List;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFavoritesResponseDto {
    private List<PostPromoResponseDto> favorites;
}