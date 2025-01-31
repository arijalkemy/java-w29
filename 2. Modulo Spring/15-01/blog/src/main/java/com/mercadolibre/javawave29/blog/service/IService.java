package com.mercadolibre.javawave29.blog.service;

import com.mercadolibre.javawave29.blog.dto.BlogDTO;
import com.mercadolibre.javawave29.blog.dto.CreatedDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IService {
    ResponseEntity<List<BlogDTO>> findAll();

    ResponseEntity<CreatedDTO> addBlog(BlogDTO blogDTO);

    ResponseEntity<BlogDTO> getBlogById(Long id);
}
