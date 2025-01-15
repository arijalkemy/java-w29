package com.meli.ej_blog.repository;

import com.meli.ej_blog.model.BlogEntry;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {

    private final Map<Integer, BlogEntry> blogEntries = new HashMap<>();

    public BlogRepositoryImpl() {
        blogEntries.put(1, new BlogEntry(1, "Introducción a Java", "Juan Pérez", "2025-01-01"));
        blogEntries.put(2, new BlogEntry(2, "Avances en Inteligencia Artificial", "María Gómez", "2025-01-02"));
        blogEntries.put(3, new BlogEntry(3, "Guía de diseño web", "Carlos Rodríguez", "2025-01-03"));
    }

    @Override
    public Integer save(BlogEntry blogEntry) {
        this.blogEntries.put(blogEntry.getId(), blogEntry);
        return blogEntry.getId();
    }

    @Override
    public Optional<BlogEntry> findById(Integer id) {
        return Optional.ofNullable(blogEntries.getOrDefault(id, null));
    }

    @Override
    public List<BlogEntry> findAll() {
        return new ArrayList<>(this.blogEntries.values());
    }
}
