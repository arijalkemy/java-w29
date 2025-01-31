package com.mercadolibre.javawave29.blog.repository;

import com.mercadolibre.javawave29.blog.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepository implements IRepository{

    private List<Blog> blogs;

    public BlogRepository () {
        blogs = new ArrayList<>();
    }

    @Override
    public List<Blog> findAll() {
        return blogs;
    }

    @Override
    public Blog findById(Long id) {
        return blogs
                .stream()
                .filter(b -> b.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public boolean save(Blog blog) {
        return blogs.add(blog);
    }
}
