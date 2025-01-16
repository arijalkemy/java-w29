package com.ejercicio.service;

import com.ejercicio.dto.BlogDto;
import com.ejercicio.model.EntradaBlog;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IEntradaBlogService {
    Long addOne(BlogDto dto);

    BlogDto getBlogById(Long id);

    List<BlogDto> getAllBlogs();
}
