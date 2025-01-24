package com.meliBootcamp.Exceptions.repository;

import com.meliBootcamp.Exceptions.entity.Blog;

import java.util.List;

public interface IRepositoryBlog {
    public void guardarBlog(Blog blog);
    public Blog buscarBlog(String id);
    public List<Blog> buscarBlogs();
}
