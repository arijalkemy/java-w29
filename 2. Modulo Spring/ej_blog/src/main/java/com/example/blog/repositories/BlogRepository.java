package com.example.blog.repositories;

import com.example.blog.entities.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface BlogRepository {

    Boolean save(EntradaBlog entradaBlog);

    List<EntradaBlog> getAll();

    Optional<EntradaBlog> getById(Long id);

}
