package com.socialmeli.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record CategoryCountByUserDto(
        @JsonProperty("user_id") Integer userId,
        @JsonProperty("user_name") String userName,
        List<CategoryCountDto> report
) {}
