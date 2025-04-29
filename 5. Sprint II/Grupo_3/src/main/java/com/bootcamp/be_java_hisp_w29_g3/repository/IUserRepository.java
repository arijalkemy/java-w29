package com.bootcamp.be_java_hisp_w29_g3.repository;

import com.bootcamp.be_java_hisp_w29_g3.entity.Buyer;
import com.bootcamp.be_java_hisp_w29_g3.entity.Post;
import com.bootcamp.be_java_hisp_w29_g3.entity.Seller;

import java.time.LocalDate;
import java.util.List;

public interface IUserRepository {
    List<Seller> getSellersFollowedByBuyer(Integer buyerId);
    Long countPromotionalProductsBySeller(Integer sellerId);
    void followSeller(Integer userId, Integer userIdToFollow);
    void unfollowSeller(Integer userId, Integer userIdToUnfollow);
    boolean existsSellerById(Integer userIdToFollow);
    boolean existsBuyerById(Integer userId);
    boolean buyerAlreadyFollowsSeller(Integer userId, Integer userIdToFollow);
    Buyer getBuyerById(Integer userId);
    Post addPostToSeller(Integer userId, Post newPost);
    List<Buyer> getBuyersFollowingSeller(Integer sellerId);
    Seller getSellerById(Integer id);
    List<Buyer> getFollowers(Integer sellerId);
    List<Integer> getAllSellersId();
    List<Seller> getSellersByRangePrice(Double minPrice, Double maxPrice, String product);
    List<Post> findPostsFromSellerByUserIdWithLimitDate(Integer userId, LocalDate limitDate);
}
