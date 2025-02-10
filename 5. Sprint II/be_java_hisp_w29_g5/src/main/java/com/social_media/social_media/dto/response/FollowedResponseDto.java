package com.social_media.social_media.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;

import java.util.List;


@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FollowedResponseDto {
    private Long user_id;
    private String user_name;
    private List<UserResponseDto> followed;
}
