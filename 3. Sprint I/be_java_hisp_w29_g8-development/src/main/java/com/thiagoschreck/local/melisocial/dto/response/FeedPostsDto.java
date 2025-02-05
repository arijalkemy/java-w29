package com.thiagoschreck.local.melisocial.dto.response;

import java.util.List;

public record FeedPostsDto(
        int userId,
        List<PostWithNoPromoAndDiscountDto> posts
){
}
