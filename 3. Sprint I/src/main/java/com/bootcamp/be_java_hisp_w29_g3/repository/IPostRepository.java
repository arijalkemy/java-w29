package com.bootcamp.be_java_hisp_w29_g3.repository;

import com.bootcamp.be_java_hisp_w29_g3.entity.Post;

import java.util.List;

public interface IPostRepository {
    List<Post> findAll();
    void addPost(Post post);
    List<Post> filterPostsByDiscountRange(Integer initialValue, Integer finalValue);
}
