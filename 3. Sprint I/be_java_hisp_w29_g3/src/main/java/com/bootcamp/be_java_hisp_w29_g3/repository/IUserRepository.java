package com.bootcamp.be_java_hisp_w29_g3.repository;

import com.bootcamp.be_java_hisp_w29_g3.entity.Buyer;
import com.bootcamp.be_java_hisp_w29_g3.entity.Post;
import com.bootcamp.be_java_hisp_w29_g3.entity.Seller;

import java.time.LocalDate;
import java.util.List;

public interface IUserRepository {
    List<Seller> getSellersFollowedByBuyer(int buyerId);
    Long countPromotionalProductsBySeller(int sellerId);
    void followSeller(int userId, int userIdToFollow);
    void unfollowSeller(int userId, int userIdToUnfollow);
    boolean existsSellerById(int userIdToFollow);
    boolean existsBuyerById(int userId);
    boolean buyerAlreadyFollowsSeller(int userId, int userIdToFollow);
    Buyer getBuyerById(Integer userId);
    Post addPostToSeller(Integer userId, Post newPost);
    List<Buyer> getBuyersFollowingSeller(Integer sellerId);
    Seller getSellerById(Integer id);
    List<Buyer> getFollowers(int sellerId, String order);
    List<Integer> getAllSellersId();
    List<Seller> getSellersByRangePrice(Double minPrice, Double maxPrice, String product);
    List<Post> findPostsFromSellerByUserIdWithLimitDate(Integer userId, LocalDate limitDate, String order);
}
