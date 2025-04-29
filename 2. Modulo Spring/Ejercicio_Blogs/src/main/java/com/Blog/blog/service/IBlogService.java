package com.Blog.blog.service;

import com.Blog.blog.dto.AddBlogDto;
import com.Blog.blog.dto.ResponseBlogDto;

import java.util.List;

public interface IBlogService {

    ResponseBlogDto addBlog(AddBlogDto blogDto);

    AddBlogDto getBlogById(Integer id);

    List<AddBlogDto> getAllBlogs();
}
