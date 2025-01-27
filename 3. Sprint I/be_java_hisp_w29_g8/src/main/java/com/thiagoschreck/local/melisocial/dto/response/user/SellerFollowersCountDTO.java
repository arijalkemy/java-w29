package com.thiagoschreck.local.melisocial.dto.response.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SellerFollowersCountDTO(
        @JsonProperty("user_id")
        int userId,
        @JsonProperty("user_name")
        String userName,
        @JsonProperty("followers_count")
        int followersCount
) {
}
