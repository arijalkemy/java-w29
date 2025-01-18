package com.bootcamp.youtuber.repository;

import com.bootcamp.youtuber.model.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EntradaBlogRepository {

    private final Map<Integer, EntradaBlog> blogs = new HashMap<>();

    public boolean existsById(int id) {
        return blogs.containsKey(id);
    }

    public Optional<EntradaBlog> findById(int id) {
        return Optional.ofNullable(blogs.get(id));
    }

    public List<EntradaBlog> getAll() {
        return new ArrayList<>(blogs.values());
    }

    public void save(EntradaBlog entradaBlog) {
        blogs.put(entradaBlog.getId(), entradaBlog);
    }
}
