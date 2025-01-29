package com.example.blog.service;

import com.example.blog.dto.EntradaBlogDto;

import java.util.List;

public interface IBlogService {
    String crearEntradaBlog(EntradaBlogDto entradaBlogDto);
    EntradaBlogDto getBlogById(Long id);
    List<EntradaBlogDto> getAll();
}
