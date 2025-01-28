package com.socialmeli.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record TopSellersDto(
        @JsonProperty("top_sellers") List<UserFollowerCountDto> sellers
) {}
