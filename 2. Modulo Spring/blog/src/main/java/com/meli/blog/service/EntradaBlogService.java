package com.meli.blog.service;

import com.meli.blog.dto.EntradaBlogDTO;
import com.meli.blog.entity.EntradaBlog;

import java.util.List;

public interface EntradaBlogService {
    Long create(EntradaBlog entradaBlog);
    EntradaBlogDTO findById(Long id);
    List<EntradaBlogDTO> findAll();
}
