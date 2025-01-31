package com.mercadolibre.javawave29.blog.repository;

import com.mercadolibre.javawave29.blog.model.Blog;

import java.util.List;

public interface IRepository {
    List<Blog> findAll();

    Blog findById(Long id);

    boolean save(Blog blog);
}
