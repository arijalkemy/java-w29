package com.ejercicio.repository;

import com.ejercicio.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IEntradaBlogRepository {
    Optional<Blog> save(Blog entradaBlog);

    Optional<Blog> findBlogById(Long id);

    List<Blog> findAllBlogs();
}
