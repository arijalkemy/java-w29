package com.example.blog.services;

import com.example.blog.dto.EntradaBlogRequest;
import com.example.blog.entities.EntradaBlog;

import java.util.List;

public interface BlogService {

    EntradaBlog save(EntradaBlogRequest entradaBlogRequest);

    EntradaBlog findById(Long id);

    List<EntradaBlog> findAll();

}
