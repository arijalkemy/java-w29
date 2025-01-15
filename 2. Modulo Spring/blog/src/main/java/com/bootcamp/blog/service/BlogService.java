package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.BlogCreatedDTO;
import com.bootcamp.blog.dto.BlogDTO;

import java.util.List;

public interface BlogService {
    BlogCreatedDTO addBlog(BlogDTO request);
    BlogDTO getBlog(Integer id);
    List<BlogDTO> getBlogs();
}
