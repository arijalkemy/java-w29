package com.example.blog.repositories;

import com.example.blog.entities.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepositoryImpl implements BlogRepository {

    private final List<EntradaBlog> entradasBlogs = new ArrayList<>();

    @Override
    public Boolean save(EntradaBlog entradaBlog) {
        entradaBlog.setId((long) (entradasBlogs.size() + 1));
        return entradasBlogs.add(entradaBlog);
    }

    @Override
    public List<EntradaBlog> findAll() {
        return entradasBlogs;
    }

    @Override
    public Optional<EntradaBlog> findById(Long id) {
        return entradasBlogs.stream()
                .filter(entradaBlog -> entradaBlog.getId().equals(id))
                .findFirst();
    }
}
