package com.ejercicio.repository;

import com.ejercicio.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository{

    private Map<Long, EntradaBlog> blogs = new HashMap<>();

    @Override
    public List<EntradaBlog> findAll() {
        return blogs.values().stream().toList();
    }

    @Override
    public Optional<EntradaBlog> save(EntradaBlog entradaBlog){
        if (blogs.containsKey(entradaBlog.getId())) {
            return Optional.empty();
        }
        blogs.put(entradaBlog.getId(), entradaBlog);
        return Optional.of(entradaBlog);
    }

    @Override
    public Optional<EntradaBlog> findBlogById(Long id) {
        return Optional.ofNullable(blogs.get(id));
    }

}
