package com.bootcamp.be_java_hisp_w29_g07.repository;

import com.bootcamp.be_java_hisp_w29_g07.entity.Post;

import java.util.List;
import java.util.Optional;

/**
 * This interface provides methods for interacting with the data related to posts.
 */
public interface IPostRepository {

    Long findPromoPostCountByUserId(Integer userId);
    Post savePost(Post post);
    Optional<Post> findPostById(Integer id);
    List<Post> findAll();
    Integer findNextId();
    List<Post> findPostsByUserIdsAndLastTwoWeeks(List<Integer> userFollowing);
    List<Post> findAllPostsByUserId(Integer userId);
    void deleteAll();
}
