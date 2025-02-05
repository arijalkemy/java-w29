package com.project.be_java_hisp_w29_g10.repository;

import com.project.be_java_hisp_w29_g10.entity.Post;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IPostRepository {
    Optional<Post> getById(Long id);
    Post save(Post newPost);
    Boolean delete(Post post);

    List<Post> getPromoPostBySellerID(Long userId);
    List<Post> getAll(Long sellerId, Boolean hasPromo, Integer category);
    List<Post> getPostsBySellerID(Long sellerId);
}
