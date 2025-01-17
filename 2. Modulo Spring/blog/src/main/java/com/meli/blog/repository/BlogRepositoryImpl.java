package com.meli.blog.repository;

import com.meli.blog.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BlogRepositoryImpl implements IBlogRepository{
    private Map<Integer,Blog> blogs;

    public BlogRepositoryImpl() {
        this.blogs = new HashMap<>();
    }


    @Override
    public Blog save(Blog blog) {
        this.blogs.put(blog.getId(), blog);
        return blog;
    }

    @Override
    public Blog findById(Integer id) {
        Blog blog = this.blogs.get(id);
        return blog;
    }

    @Override
    public List<Blog> findAll() {
        return new ArrayList<>(this.blogs.values());
    }

    @Override
    public Boolean existsById(Integer id) {
        return this.blogs.containsKey(id);
    }
}
