package com.meli.blog.repository;

import com.meli.blog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BlogRepositoryImpl implements IBlogRepository{

    private Map<Integer, Blog> blogs = new HashMap<>();

    @Override
    public Optional<Blog> save(Blog blog) {
        if (blogs.keySet().contains(blog.getId())) {
            return Optional.ofNullable(null);
        }
        blogs.put(blog.getId(), blog);
        return Optional.of(blog);
    }

    @Override
    public Optional<Blog> getById(Integer id) {
        return Optional.ofNullable(blogs.get(id));
    }

    @Override
    public List<Blog> findAll() {
        List<Blog> blogList = new ArrayList<>();
        blogs.forEach((_key, value) -> blogList.add(value));
        return blogList;
    }
}
