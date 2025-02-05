package com.blog.blog.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.blog.blog.dto.EntradaBlogDTO;
import com.blog.blog.exception.IdAlreadyExistsException;
import com.blog.blog.exception.NotFoundException;
import com.blog.blog.model.EntradaBlog;
import com.blog.blog.repository.BlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BlogService {

    private BlogRepository repo;

    public BlogService(BlogRepository repo) {
        this.repo = repo;
    }

    public Integer addblog(EntradaBlog blog) {
        
        if (!repo.existsId(blog.getId())) {
            repo.addEntrada(blog);
        }else { 
            throw new IdAlreadyExistsException("Blog already exists");
        }
        
        return blog.getId();
    }

    public List<EntradaBlogDTO> getAllBlogs() {
        ObjectMapper mapper = new ObjectMapper();

        Map<Integer,EntradaBlog> entradas = repo.getAllEntradas();
        
        return entradas.values()
                .stream()
                .map(m -> new EntradaBlogDTO(m.getId(),
                                            m.getTitulo(),
                                            m.getAutor_name(),
                                            m.getFecha()))
                .toList();
    }

    public EntradaBlogDTO getBlogById(Integer id) {
        
        Map<Integer,EntradaBlog> entradas = repo.getAllEntradas();

        if (entradas.containsKey(id)) {
            EntradaBlog entrada = entradas.get(id);
            return new EntradaBlogDTO(entrada.getId(),
                                            entrada.getTitulo(),
                                            entrada.getAutor_name(),
                                            entrada.getFecha());
        } else {
            throw new NotFoundException("Blog with id " + String.valueOf(id) + " not found");
        }
        
    }
}
