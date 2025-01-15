package org.bootcamp.manejoexcepcionesp1.repository;

import org.bootcamp.manejoexcepcionesp1.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IBlogRepository {
    EntradaBlog crearEntradaBlog(EntradaBlog blog);
    Optional<EntradaBlog> getById(Long id);
    List<EntradaBlog> getAll();
}