package com.meli.ej_blog.repository;

import com.meli.ej_blog.model.BlogEntry;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    Integer save(BlogEntry blogEntry);
    Optional<BlogEntry> findById(Integer id);
    List<BlogEntry> findAll();

}
