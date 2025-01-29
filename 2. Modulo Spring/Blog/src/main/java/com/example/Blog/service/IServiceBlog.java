package com.example.Blog.service;

import com.example.Blog.dto.DTOEntradaBlog;
import com.example.Blog.entity.EntradaBlog;

import java.util.List;

public interface IServiceBlog {
    DTOEntradaBlog addBlog(EntradaBlog entradaBlog);
    List<DTOEntradaBlog> findAll();
    DTOEntradaBlog findById(Integer id);
}
