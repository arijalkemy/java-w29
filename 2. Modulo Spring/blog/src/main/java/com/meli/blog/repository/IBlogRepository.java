package com.meli.blog.repository;

import com.meli.blog.entity.Blog;

import java.util.List;

public interface IBlogRepository {
    public Blog save(Blog blog);
    public Blog findById(Integer id);
    public List<Blog> findAll();
    public Boolean existsById(Integer id);
}
