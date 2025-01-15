package com.ejercicio.service;

import com.ejercicio.dto.BlogDto;
import com.ejercicio.model.EntradaBlog;

import java.util.List;
import java.util.Optional;

public interface IEntradaBlogService {

    List<BlogDto> findAll();
    Long addOne(BlogDto dto);
    BlogDto getBlogById(Long id);

}
