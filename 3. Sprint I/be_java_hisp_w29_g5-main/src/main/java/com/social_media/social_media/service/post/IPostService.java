package com.social_media.social_media.service.post;

import com.social_media.social_media.dto.request.PostPromoEndDateRequestDto;
import com.social_media.social_media.dto.response.*;
import com.social_media.social_media.dto.request.PostRequestDto;

import com.social_media.social_media.dto.request.PostPromoRequestDto;
import com.social_media.social_media.dto.response.PostDetailResponseDto;
import com.social_media.social_media.dto.response.PostPromoResponseDto;
import com.social_media.social_media.dto.response.PostResponseDto;

public interface IPostService {
    PostResponseDto createPost(PostRequestDto postProductRequestDto);

    PostPromoResponseDto createPostPromo(PostPromoRequestDto postPromoRequestDto);

    SellersPostsByFollowerResponseDto searchFollowedPostsFromLastTwoWeeks(Long userId, String order);

    PostDetailResponseDto searchById(Long postId);

    PromoProductsResponseDto searchSellersWithPromoPosts(Long user_id);

    PostPromoEndDateResponseDto createPostPromoEndDate(PostPromoEndDateRequestDto postPromoEndDateRequestDto);

}
