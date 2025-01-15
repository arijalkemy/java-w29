package com.bootcamp.manejo_excepciones_blog.service;

import com.bootcamp.manejo_excepciones_blog.dto.BlogRequestDTO;
import com.bootcamp.manejo_excepciones_blog.dto.BlogResponseDTO;
import com.bootcamp.manejo_excepciones_blog.exceptions.BlogAlreadyExistsException;
import com.bootcamp.manejo_excepciones_blog.exceptions.BlogNotFoundException;
import com.bootcamp.manejo_excepciones_blog.model.EntradaBlog;
import com.bootcamp.manejo_excepciones_blog.repository.BlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Integer createBlog(BlogRequestDTO blogDTO) {
        if (blogRepository.getBlogById(blogDTO.getBlogId()) != null)
            throw new BlogAlreadyExistsException("Blog with id: " + blogDTO.getBlogId() + " already exists :(");
        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        EntradaBlog entradaBlog = objectMapper.convertValue(blogDTO, EntradaBlog.class);
        entradaBlog.setPublishDate(LocalDate.now());
        return blogRepository.saveBlog(entradaBlog);
    }

    public BlogResponseDTO getBlogById(Integer id) {
        EntradaBlog blog = blogRepository.getBlogById(id);
        if (blog == null)
            throw new BlogNotFoundException("Blog with id: " + id + " was not found :(");
        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        return objectMapper.convertValue(blog, BlogResponseDTO.class);
    }

    public List<BlogResponseDTO> getAllBlogs() {
        List<EntradaBlog> blogs = blogRepository.getAllBlogs();
        ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();
        return blogs.stream()
                .map(b -> objectMapper.convertValue(b, BlogResponseDTO.class))
                .toList();
    }
}
