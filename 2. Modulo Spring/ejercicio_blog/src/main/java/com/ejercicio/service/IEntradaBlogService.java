package com.ejercicio.service;

import com.ejercicio.dto.BlogDto;
import com.ejercicio.model.EntradaBlog;

import java.util.Optional;

public interface IEntradaBlogService {
    Long addOne(BlogDto dto);

    Optional<BlogDto> getBlogById(Long id);
}
