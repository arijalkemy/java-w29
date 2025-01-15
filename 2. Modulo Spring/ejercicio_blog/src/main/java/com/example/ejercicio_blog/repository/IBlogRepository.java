package com.example.ejercicio_blog.repository;

import com.example.ejercicio_blog.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    Optional<EntradaBlog> getBlogById(Integer id);
    List<EntradaBlog> getAll();
    Integer addEntrada(EntradaBlog entradaBlog);
}
