package com.example.blog.repository;

import com.example.blog.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    EntradaBlog crearEntradaBlog(EntradaBlog blog);
    Optional<EntradaBlog> getById(Long id);
    List<EntradaBlog> getAll();
}
