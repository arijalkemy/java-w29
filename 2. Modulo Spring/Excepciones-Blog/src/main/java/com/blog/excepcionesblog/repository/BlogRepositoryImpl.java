package com.blog.excepcionesblog.repository;

import com.blog.excepcionesblog.Entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BlogRepositoryImpl implements IBlogRepository{
    private final Map<Integer, EntradaBlog> blogMap = new HashMap<>();

    @Override
    public EntradaBlog save(EntradaBlog entradaBlog) {
        return blogMap.putIfAbsent(entradaBlog.getId(), entradaBlog);
    }

    @Override
    public EntradaBlog findById(Integer id) {
        return blogMap.get(id);
    }

    @Override
    public Map<Integer, EntradaBlog> findAll() {
        return blogMap;
    }
}
