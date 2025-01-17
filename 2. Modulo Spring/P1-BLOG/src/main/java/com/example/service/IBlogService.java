package com.example.service;

import com.example.dto.BlogDto;

import java.util.List;

public interface IBlogService {

    BlogDto addBlog(BlogDto blogDto);
    BlogDto getBlogById(Integer id);
    List<BlogDto> getAllBlogs();
}
