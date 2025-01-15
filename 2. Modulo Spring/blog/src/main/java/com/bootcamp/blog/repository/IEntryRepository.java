package com.bootcamp.blog.repository;

import com.bootcamp.blog.dto.EntradaBlogDTO;
import com.bootcamp.blog.entity.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IEntryRepository {
    public EntradaBlog save(EntradaBlog entry);
    public List<EntradaBlog> findAll();
    public Optional<EntradaBlog> findByID(Integer id);
}
