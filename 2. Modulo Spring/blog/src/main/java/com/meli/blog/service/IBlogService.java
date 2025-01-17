package com.meli.blog.service;

import com.meli.blog.dto.request.CreateBlogDto;
import com.meli.blog.dto.response.CreatedBlogDto;
import com.meli.blog.entity.Blog;

import java.util.List;

public interface IBlogService {
    public CreatedBlogDto save(CreateBlogDto blog);
    public Blog getBlogById(Integer id);
    public List<Blog> findAllBlogs();
}
