package com.Blog.blog.repository;

import com.Blog.blog.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    EntradaBlog addBlog(EntradaBlog entradaBlog);
    Optional<EntradaBlog> findById(Integer id);
    List<EntradaBlog> findAll();
}
