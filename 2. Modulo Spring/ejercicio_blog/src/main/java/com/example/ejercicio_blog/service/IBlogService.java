package com.example.ejercicio_blog.service;

import com.example.ejercicio_blog.dto.EntradaBlogDto;
import com.example.ejercicio_blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogService {

    EntradaBlogDto getBlogById(Integer id);
    List<EntradaBlogDto> getAll();
    String createBlog(EntradaBlog entradaBlog);
}
