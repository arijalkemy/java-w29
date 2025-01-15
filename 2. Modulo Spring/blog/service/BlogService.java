package com.api.blog.service;

import com.api.blog.dto.BlogDTO;
import com.api.blog.entity.EntradaBlog;
import com.api.blog.repository.BlogRepository;

import java.time.LocalDate;
import java.util.Map;

public class BlogService {
    private final BlogRepository repository = new BlogRepository();

    public void createBlog(Integer id, String titulo, String autor) {
        EntradaBlog blog = new EntradaBlog(id, titulo, autor, LocalDate.now());
        repository.save(blog);
    }

    public BlogDTO getBlogById(Integer id) {
        return repository.findById(id);
    }

    public Map<Integer, EntradaBlog> getAllBlogs() {
        return repository.findAll();
    }
}
