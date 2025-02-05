package com.project.be_java_hisp_w29_g10.service;


import com.project.be_java_hisp_w29_g10.dto.request.PostRequestDto;
import com.project.be_java_hisp_w29_g10.dto.response.PostResponseDto;
import com.project.be_java_hisp_w29_g10.dto.response.PromoPostCountDto;
import com.project.be_java_hisp_w29_g10.dto.response.PromoPostResponseDto;
import com.project.be_java_hisp_w29_g10.dto.response.RecentPostsResponseDto;
import com.project.be_java_hisp_w29_g10.entity.Post;

import java.util.List;

public interface IPostService {
    Post save(PostRequestDto postDto);
    Boolean delete(Long post_id);
    Post savePromo(PostRequestDto postRequestDto);
    List<PromoPostResponseDto> getPostsBySellerId(Long sellerId, Boolean hasPromo, Integer category);
    PromoPostCountDto getPromoPostCountBySellerId(Long userId);
    RecentPostsResponseDto getRecentPostsByFollowedSellers(Long userId);
    RecentPostsResponseDto OrderByDate(RecentPostsResponseDto recentPostsResponse, String order);
}
