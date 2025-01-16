package com.practicablogexepcion.blogexepcion.repository;

import com.practicablogexepcion.blogexepcion.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepositoryImpl implements IBlogRepository{
    private final Map<Integer, Blog> blogs;

    public BlogRepositoryImpl() {
        this.blogs = new HashMap<>();
    }
    @Override
    public Blog save(Blog blog) {
        blogs.put(blog.id(), blog);
        return blog;
    }

    @Override
    public Blog findById(Integer id) {
        return blogs.get(id);
    }

    @Override
    public List<Blog> find() {
        return blogs.values().stream().toList();
    }
}
