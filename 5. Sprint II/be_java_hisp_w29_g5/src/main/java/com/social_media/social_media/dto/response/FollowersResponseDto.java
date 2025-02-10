package com.social_media.social_media.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class FollowersResponseDto {
    private Long user_id;
    private String user_name;
    private List<UserResponseDto> followers;
}
