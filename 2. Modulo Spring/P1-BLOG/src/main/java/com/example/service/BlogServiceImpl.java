package com.example.service;

import com.example.dto.BlogDto;
import com.example.entities.EntradaBlog;
import com.example.exception.ConflictException;
import com.example.exception.NotFoundException;
import com.example.repository.IBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImpl implements IBlogService{

    private final ObjectMapper objectMapper;
    IBlogRepository repository;
    ObjectMapper mapper;

    public BlogServiceImpl(IBlogRepository repository, ObjectMapper objectMapper) {
        this.repository = repository;
        this.mapper = new ObjectMapper();
        this.objectMapper = objectMapper;
    }

    @Override
    public BlogDto addBlog(BlogDto blogDto) {
        EntradaBlog entradaBlog = mapper.convertValue(blogDto, EntradaBlog.class);
        if(repository.existsById(entradaBlog.getId())) {
            throw new ConflictException("El id del blog ya existe");
        }
        repository.add(entradaBlog);
        return objectMapper.convertValue(entradaBlog, BlogDto.class);
    }

    @Override
    public BlogDto getBlogById(Integer id) {
        EntradaBlog blog = repository.getBlogById(id);
        if(blog == null) {
            throw new NotFoundException("No se encontro el blog con id " + id);
        }
        return objectMapper.convertValue(blog, BlogDto.class);
    }

    @Override
    public List<BlogDto> getAllBlogs() {
        List<EntradaBlog> blogs = repository.getAll();
        return blogs.stream().map(blog -> objectMapper.convertValue(blog, BlogDto.class)).toList();
    }
}
