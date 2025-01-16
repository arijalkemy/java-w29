package org.example.manejo_excepciones_1_vivo.repository;

import org.example.manejo_excepciones_1_vivo.entity.EntradaBlog;

import java.util.List;

public interface IRepositoryBlog {
    EntradaBlog createBlog(EntradaBlog entradaBlog);

    List<EntradaBlog> getBlogs();

    EntradaBlog getBlogById(Integer id);
}
