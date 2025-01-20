package com.example.blog_exercise.repository;


import com.example.blog_exercise.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    List<EntradaBlog> getAllBlogs();

    Optional<EntradaBlog> getBlogById(Long id);

    Long saveBlog(EntradaBlog blog);
}
