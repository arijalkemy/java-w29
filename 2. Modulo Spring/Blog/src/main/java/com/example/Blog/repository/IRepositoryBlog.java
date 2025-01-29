package com.example.Blog.repository;

import com.example.Blog.entity.EntradaBlog;

import java.util.List;

public interface IRepositoryBlog {
    EntradaBlog addBlog(EntradaBlog entradaBlog);
    List<EntradaBlog> findAll();
    EntradaBlog findById(Integer id);
}
