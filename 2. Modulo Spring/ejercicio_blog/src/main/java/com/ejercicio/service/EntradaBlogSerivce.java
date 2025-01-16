package com.ejercicio.service;

import com.ejercicio.dto.BlogDto;
import com.ejercicio.exception.BlogNotCreatedException;
import com.ejercicio.exception.BlogNotFoundException;
import com.ejercicio.model.EntradaBlog;
import com.ejercicio.repository.IEntradaBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntradaBlogSerivce implements IEntradaBlogService{

    @Autowired
    private IEntradaBlogRepository entradaBlogRepository;

    @Override
    public Long addOne(BlogDto dto) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<EntradaBlog> blog = entradaBlogRepository.save(mapper.convertValue(dto, EntradaBlog.class));
        if (blog.isEmpty()) {
            throw new BlogNotCreatedException("No se pudo crear el blog");
        }
        return blog.get().getId();
    }

    @Override
    public BlogDto getBlogById(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<EntradaBlog> blog = entradaBlogRepository.findBlogById(id);
        if(blog.isEmpty()){
            throw new BlogNotFoundException("No se encontró el blog con el id: "+id);
        }
        EntradaBlog blogTraduced = mapper.convertValue(blog, EntradaBlog.class);
        return mapper.convertValue(blogTraduced, BlogDto.class);
    }

    public List<BlogDto> getAllBlogs(){
        ObjectMapper mapper = new ObjectMapper();
        return entradaBlogRepository.findAll().stream().map(blog -> mapper.convertValue(blog, BlogDto.class))
                .collect(Collectors.toList());
    }
}
