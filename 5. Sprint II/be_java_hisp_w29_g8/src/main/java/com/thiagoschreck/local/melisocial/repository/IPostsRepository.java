package com.thiagoschreck.local.melisocial.repository;

import com.thiagoschreck.local.melisocial.entity.product.Post;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public interface IPostsRepository {
    Integer getIdentity();

    List<Post> getAllPromoPostsFromSeller(Integer sellerId);

    Post save(Post post);

    List<Post> getAllPostFromSellersWithinWeeksAgo(Integer sellerId, LocalDate weeksAgo);

    Stream<Post> getAllPostFromSellersWithinWeeksAgoOrderAsc(Integer sellerId, LocalDate weeksAgo);


    long getPromoPostsCountFromSeller(Integer sellerId);
}
