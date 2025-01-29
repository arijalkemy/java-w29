package com.example.Blog.service;

import com.example.Blog.dto.DTOEntradaBlog;
import com.example.Blog.entity.EntradaBlog;
import com.example.Blog.repository.RepositoryBlog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceBlog implements IServiceBlog {

    private final RepositoryBlog repositoryBlog;

    public ServiceBlog(RepositoryBlog repositoryBlog) {
        this.repositoryBlog = repositoryBlog;
    }

    @Override
    public DTOEntradaBlog addBlog(DTOEntradaBlog entradaBlog) {
        repositoryBlog.addBlog(new EntradaBlog());
        return new DTOEntradaBlog(entradaBlog.getTituloBlog(),entradaBlog.getNombreAutor(),entradaBlog.getFechaPublicacion());
    }

    @Override
    public List<DTOEntradaBlog> findAll() {
        return repositoryBlog.findAll().stream().map(blog -> new DTOEntradaBlog(blog.getTituloBlog(),blog.getNombreAutor(),blog.getFechaPublicacion())).collect(Collectors.toList());
    }

    @Override
    public DTOEntradaBlog findById(Integer id) {
        EntradaBlog entradaBlog = repositoryBlog.findById(id);
        return new DTOEntradaBlog(entradaBlog.getTituloBlog(),entradaBlog.getNombreAutor(),entradaBlog.getFechaPublicacion());
    }
}
