package com.Blog.blog.service;

import com.Blog.blog.dto.AddBlogDto;
import com.Blog.blog.dto.ResponseBlogDto;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    ResponseBlogDto addBlog(AddBlogDto blogDto);
    AddBlogDto getBlog(Integer id);
    List<AddBlogDto> getAllBlogs();
}
