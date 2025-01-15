package com.bootcamp.blog.repository;

import com.bootcamp.blog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BlogRepositoryImpl implements BlogRepository {
    List<Blog> blogs = new ArrayList<>();

    @Override
    public Blog save(Blog blog) {
        blogs.add(blog);
        return blog;
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return blogs.stream().filter(blog -> blog.getId().equals(id)).findFirst();
    }

    @Override
    public List<Blog> findAll() {
        return blogs;
    }
}
