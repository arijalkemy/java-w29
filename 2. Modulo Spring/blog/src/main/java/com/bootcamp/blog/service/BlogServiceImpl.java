package com.bootcamp.blog.service;

import com.bootcamp.blog.dto.BlogCreatedDTO;
import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.entity.Blog;
import com.bootcamp.blog.exception.BlogBadRequestException;
import com.bootcamp.blog.exception.BlogNotFoundException;
import com.bootcamp.blog.repository.BlogRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService{

    private final BlogRepository repository;
    private final ObjectMapper objectMapper;

    @Override
    public BlogCreatedDTO addBlog(BlogDTO request) {
        validatePresenceById(request.getId());
        Blog blog = objectMapper.convertValue(request, Blog.class);
        repository.save(blog);
        return buildCreatedDTO(blog.getId());
    }

    private void validatePresenceById(Integer id){
        Optional<Blog> oBlog = repository.findById(id);
        if(oBlog.isPresent())
            throw new BlogBadRequestException("Ya se encuentra un blog con ese id");
    }

    private BlogCreatedDTO buildCreatedDTO(Integer id){
        BlogCreatedDTO dto = new BlogCreatedDTO();
        dto.setId(id);
        dto.setMessage("Se guardo el blog con el id: " + id);
        return dto;
    }

    @Override
    public BlogDTO getBlog(Integer id) {
        Optional<Blog> oBlog = repository.findById(id);
        if(oBlog.isEmpty())
            throw new BlogNotFoundException("No se encuentra un blog con ese id");

        return objectMapper.convertValue(oBlog, BlogDTO.class);
    }

    @Override
    public List<BlogDTO> getBlogs() {
        List<Blog> blogs = repository.findAll();
        if(blogs.isEmpty())
            throw new BlogNotFoundException("No existen blogs");

        return objectMapper.convertValue(blogs, new TypeReference<>() {});
    }
}