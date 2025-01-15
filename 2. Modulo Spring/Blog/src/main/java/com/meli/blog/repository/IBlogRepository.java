package com.meli.blog.repository;

import com.meli.blog.entity.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    Optional<Blog> getById(Integer id);
    Optional<Blog> save(Blog blog);
    List<Blog> findAll();
}
