package com.thiagoschreck.local.melisocial.service;

import com.thiagoschreck.local.melisocial.dto.response.PromoPostsCountDTO;
import com.thiagoschreck.local.melisocial.dto.request.CreatePostDTO;
import com.thiagoschreck.local.melisocial.dto.response.FeedPostsDto;

import java.util.List;

public interface IPostsService {
	CreatePostDTO saveWithoutDiscount(CreatePostDTO createPostDto);
	List<FeedPostsDto> searchPostsByFollowedSellersWithinWeeksAgoOrder(Integer userId, String order);
	List<FeedPostsDto> searchPostsByFollowedSellersWithinWeeksAgo(Integer clientId);

    CreatePostDTO saveWithDiscount(CreatePostDTO createPostDto);
	PromoPostsCountDTO getPromoPostsCountFromSeller(Integer sellerId);
}
