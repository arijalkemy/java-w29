package com.example.repository;

import com.example.dto.BlogDto;
import com.example.entities.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements IBlogRepository{
    List<EntradaBlog> blogs = new ArrayList<>();


    @Override
    public EntradaBlog add(EntradaBlog blog) {
        blogs.add(blog);
        return blog;
    }

    @Override
    public EntradaBlog getBlogById(Integer id) {
        return blogs.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<EntradaBlog> getAll() {
        return blogs;
    }

    @Override
    public Boolean existsById(Integer id) {
        return blogs.stream().anyMatch(b -> b.getId().equals(id));
    }
}
