package com.ejercicio.service;

import com.ejercicio.dto.BlogDto;
import com.ejercicio.exception.BlogNotCreatedException;
import com.ejercicio.exception.BlogNotFoundException;
import com.ejercicio.model.Blog;
import com.ejercicio.repository.IEntradaBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EntradaBlogSerivce implements IEntradaBlogService {

    @Autowired
    private IEntradaBlogRepository entradaBlogRepository;

    @Override
    public Long addOne(BlogDto dto) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<Blog> blog = entradaBlogRepository.save(mapper.convertValue(dto, Blog.class));
        if (blog.isEmpty()) {
            throw new BlogNotCreatedException("No se pudo crear el blog");
        }
        return blog.get().getId();
    }

    @Override
    public BlogDto getBlogById(Long id) {
        Blog blog = entradaBlogRepository.findBlogById(id)
                .orElseThrow(() -> new BlogNotFoundException("No existe blog con ese ID"));
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(blog, BlogDto.class);
    }

    @Override
    public List<BlogDto> findAllBlogs() {
        List<Blog> blogs = entradaBlogRepository.findAllBlogs();
        if (blogs.isEmpty()) {
            throw new RuntimeException("No hay blogs");
        }
        ObjectMapper mapper = new ObjectMapper();
        return blogs.stream()
                .map(b -> mapper.convertValue(b, BlogDto.class))
                .toList();
    }
}
