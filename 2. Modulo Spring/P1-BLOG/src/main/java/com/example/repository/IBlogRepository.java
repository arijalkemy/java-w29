package com.example.repository;

import com.example.dto.BlogDto;
import com.example.entities.EntradaBlog;

import java.util.List;

public interface IBlogRepository {

    EntradaBlog add(EntradaBlog blog);
    EntradaBlog getBlogById(Integer id);
    List<EntradaBlog> getAll();
    Boolean existsById(Integer id);
}
