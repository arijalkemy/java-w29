package com.social_media.social_media.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FollowedResponseDto {
    private Long user_id;
    private String user_name;
    private List<UserResponseDto> followed;
}
