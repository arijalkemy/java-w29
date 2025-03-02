package com.blog.excepcionesblog.repository;

import com.blog.excepcionesblog.Entity.EntradaBlog;

import java.util.Map;

public interface IBlogRepository {
    EntradaBlog save(EntradaBlog entradaBlog);

    EntradaBlog findById(Integer id);

    Map<Integer, EntradaBlog> findAll();
}
