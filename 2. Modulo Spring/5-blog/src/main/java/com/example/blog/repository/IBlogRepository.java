package com.example.blog.repository;

import com.example.blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    // Long nextId();
    EntradaBlog getById(Long id);
    Long addEntradaBlog(EntradaBlog entradaBlog);
    List<EntradaBlog> findAll();

}
