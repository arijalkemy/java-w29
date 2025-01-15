package com.ejercicio.repository;

import com.ejercicio.model.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IEntradaBlogRepository {

    List<EntradaBlog> findAll();

    Optional<EntradaBlog> save(EntradaBlog entradaBlog);

    Optional<EntradaBlog> findBlogById(Long id);
}
