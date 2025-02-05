package com.org.meli.ejercicioBlog.repository;

import com.org.meli.ejercicioBlog.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    Optional<EntradaBlog> getBlogById(Integer id);
    List<EntradaBlog> getAll();
    void addEntrada(EntradaBlog entradaBlog);
}
