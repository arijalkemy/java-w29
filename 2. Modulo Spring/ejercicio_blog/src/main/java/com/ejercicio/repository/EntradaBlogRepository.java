package com.ejercicio.repository;

import com.ejercicio.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository {

    private Map<Long, Blog> blogs = new HashMap<>();

    @Override
    public Optional<Blog> save(Blog blog) {
        if (blogs.containsKey(blog.getId())) {
            return Optional.empty();
        }
        blogs.put(blog.getId(), blog);
        return Optional.of(blog);
    }

    @Override
    public Optional<Blog> findBlogById(Long id) {
        return Optional.ofNullable(blogs.get(id));
    }

    @Override
    public List<Blog> findAllBlogs() {
        return new ArrayList<>(blogs.values());
    }

}
