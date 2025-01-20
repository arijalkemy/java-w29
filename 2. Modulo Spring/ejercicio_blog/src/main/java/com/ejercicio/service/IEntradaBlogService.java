package com.ejercicio.service;

import com.ejercicio.dto.BlogDto;

import java.util.List;

public interface IEntradaBlogService {

    Long addOne(BlogDto dto);

    BlogDto getBlogById(Long id);

    List<BlogDto> findAllBlogs();
}
