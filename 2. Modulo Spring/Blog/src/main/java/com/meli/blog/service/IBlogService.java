package com.meli.blog.service;

import com.meli.blog.dto.BlogDto;

import java.util.List;

public interface IBlogService {
    BlogDto getById(Integer id);
    BlogDto save(BlogDto blog);
    List<BlogDto> getAll();
}
