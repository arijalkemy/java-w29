package com.meli.scaffolding.repositories;

import com.meli.scaffolding.entity.Blog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    Optional<Blog> getById(Integer id);
    Optional<Blog> save(Blog blog);
    List<Blog> findAll();
}
