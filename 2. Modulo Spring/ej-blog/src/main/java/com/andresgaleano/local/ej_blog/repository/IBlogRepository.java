package com.andresgaleano.local.ej_blog.repository;

import com.andresgaleano.local.ej_blog.entity.Blog;

import java.util.List;

public interface IBlogRepository {
    Blog save(Blog blog);

    Blog findById(Integer id);

    List<Blog> find();
}
