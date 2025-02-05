package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.UserDto;
import lombok.Getter;

@Getter
public class FollowersCountDto extends UserDto {

    @JsonProperty("followers_count")
    private int followersCount;

    public FollowersCountDto(Integer userId, String userName, int followersCount) {
        super(userId, userName);
        this.followersCount = followersCount;
    }
}
