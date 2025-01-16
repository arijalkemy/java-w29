package com.practicablogexepcion.blogexepcion.repository;

import com.practicablogexepcion.blogexepcion.entity.Blog;

import java.util.List;

public interface IBlogRepository {
    Blog save(Blog blog);

    Blog findById(Integer id);

    List<Blog> find();
}
