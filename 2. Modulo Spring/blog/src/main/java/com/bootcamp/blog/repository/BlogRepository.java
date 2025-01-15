package com.bootcamp.blog.repository;

import com.bootcamp.blog.entity.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogRepository {
    Blog save(Blog blog);

    Optional<Blog> findById(Integer id);

    List<Blog> findAll();
}
