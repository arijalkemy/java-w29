package com.example.blog_exercise.service;


import com.example.blog_exercise.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<EntradaBlog> getAllBlogs();

    Optional<EntradaBlog> getBlogById(Long id);

    Long saveBlog(EntradaBlog blog);
}
