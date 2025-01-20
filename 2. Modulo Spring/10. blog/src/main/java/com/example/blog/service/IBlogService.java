package com.example.blog.service;

import com.example.blog.dto.EntradaBlogDto;

import java.util.List;

public interface IBlogService {
    String crearEntradaBlog(EntradaBlogDto blog);
    EntradaBlogDto getEntradaBlog(Long id);
    List<EntradaBlogDto> getAllEntradasBlog();
}
