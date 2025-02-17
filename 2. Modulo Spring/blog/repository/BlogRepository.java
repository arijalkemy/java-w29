package com.api.blog.repository;

import com.api.blog.dto.BlogDTO;
import com.api.blog.entity.EntradaBlog;
import com.api.blog.exception.BlogAlreadyExistsException;
import com.api.blog.exception.BlogNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class BlogRepository {
    private final Map<Integer, EntradaBlog> blogs = new HashMap<>();

    public void save(EntradaBlog blog) {
        if (blogs.containsKey(blog.getId())) {
            throw new BlogAlreadyExistsException("El blog con id: " + blog.getId() + " ya existe.");
        }
        blogs.put(blog.getId(), blog);
    }

    public BlogDTO findById(Integer id) {
        if (!blogs.containsKey(id)) {
            throw new BlogNotFoundException("No se encontro el blog con id: " + id + ".");
        }
        EntradaBlog blog = blogs.get(id);
        return new BlogDTO(blog.getId(), blog.getTitulo(), blog.getAutor());
    }

    public Map<Integer, EntradaBlog> findAll() {
        return blogs;
    }
}

