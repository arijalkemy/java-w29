package com.bootcamp.be_java_hisp_w29_g3.service;

import com.bootcamp.be_java_hisp_w29_g3.dto.BuyerFollowedSellersDto;
import com.bootcamp.be_java_hisp_w29_g3.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w29_g3.dto.response.*;

import java.util.List;

public interface ISocialMeliService {
    FollowDto followSeller(int userId, int userIdToFollow);
    UnfollowDto unfollowSeller(int userId, int userIdToUnfollow);
    BuyerFollowedSellersDto getUserFollowSellers(Integer buyerId, String order);
    PromoProductDto getPromoProducts(Integer userId);
    UserFollowersDTO getFollowers(int sellerId, String order);
    PostResponseDto createPost(PostRequestDto post);
    FollowerCountDTO calculateSellerFollowerCount(Integer sellerId);
    List<FollowerCountDTO> getSellersByFollowerCount();
    List<ProductFilterDto> getProductByRangePrice(Double minPrice, Double maxPrice, String product);
    PostsByUserResponseDto searchPostsByUserIdInLastTwoWeeks(Integer userId, String order);
    List<PostDto> filterPostsByDiscountRange(Integer initialValue, Integer finalValue);
}
