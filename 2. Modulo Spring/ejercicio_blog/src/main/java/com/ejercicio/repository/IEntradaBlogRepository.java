package com.ejercicio.repository;

import com.ejercicio.model.EntradaBlog;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IEntradaBlogRepository {
    Optional<EntradaBlog> save(EntradaBlog entradaBlog);

    Optional<EntradaBlog> findBlogById(Long id);

    List<EntradaBlog> findAll();
}
