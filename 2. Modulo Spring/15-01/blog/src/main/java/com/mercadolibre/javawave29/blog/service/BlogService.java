package com.mercadolibre.javawave29.blog.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.javawave29.blog.dto.BlogDTO;
import com.mercadolibre.javawave29.blog.dto.CreatedDTO;
import com.mercadolibre.javawave29.blog.exceptions.ConflictException;
import com.mercadolibre.javawave29.blog.exceptions.NotFoundException;
import com.mercadolibre.javawave29.blog.model.Blog;
import com.mercadolibre.javawave29.blog.repository.IRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class BlogService implements IService{
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final IRepository repository;

    public BlogService (IRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<List<BlogDTO>> findAll() {
        List<Blog> blogs = repository.findAll();
        if (blogs.isEmpty()) throw new NotFoundException("No se encontraron blogs.");
        List<BlogDTO> blogsDTO = blogs
                .stream()
                .map(b -> objectMapper.convertValue(b, BlogDTO.class))
                .toList();
        return ResponseEntity.ok(blogsDTO);
    }

    @Override
    public ResponseEntity<CreatedDTO> addBlog(BlogDTO blogDTO) {
        if (repository.findById(blogDTO.getId()) != null) throw new ConflictException("Ya se encuentra creado un blog con ese id.");
        Blog blog = objectMapper.convertValue(blogDTO, Blog.class);
        if (!repository.save(blog)) throw new InternalError("Ocurrió un error al crear el blog.");
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreatedDTO(blog.getId(), "Blog creado correctamente."));
    }

    @Override
    public ResponseEntity<BlogDTO> getBlogById(Long id) {
        Blog blog = repository.findById(id);
        if (blog == null) throw new NotFoundException("No existe un blog con ese id.");
        BlogDTO blogDTO = objectMapper.convertValue(blog, BlogDTO.class);
        return ResponseEntity.ok(blogDTO);
    }
}
