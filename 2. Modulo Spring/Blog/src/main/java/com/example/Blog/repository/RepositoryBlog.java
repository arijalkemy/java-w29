package com.example.Blog.repository;

import com.example.Blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class RepositoryBlog implements IRepositoryBlog {
    private List<EntradaBlog> entradaBlogs;

    public RepositoryBlog(List<EntradaBlog> entradaBlogs) {
        this.entradaBlogs = entradaBlogs;
    }
    @Override
    public EntradaBlog addBlog(EntradaBlog entradaBlog) {
        entradaBlogs.add(entradaBlog);
        return entradaBlog;
    }

    @Override
    public EntradaBlog findById(Integer id) {
        return entradaBlogs.stream()
                .filter(entradaBlog -> entradaBlog.getIdBlog()
                        .equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<EntradaBlog> findAll() {
        return entradaBlogs;
    }
}
