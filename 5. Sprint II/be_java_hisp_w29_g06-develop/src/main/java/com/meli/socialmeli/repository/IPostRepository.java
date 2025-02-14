package com.meli.socialmeli.repository;

import com.meli.socialmeli.entity.Post;
import com.meli.socialmeli.entity.Seller;

import java.util.List;
import java.util.Optional;

public interface IPostRepository {
    Optional<Post> save(Post post);
    Long getCountPostInSaleBySellerId(Integer userId);
    Optional<Post> getById(Integer id);
    List<Post> getPostsBySellers(List<Seller> sellers);
    List<Post> getPostsInSaleBySellerId(Integer sellerId);
    List<Post> getPostsByPrice(Double minPrice, Double maxPrice);
    List<Post> getPostsByMinPrice(Double minPrice);
    List<Post> getPostsByMaxPrice(Double maxPrice);
}
