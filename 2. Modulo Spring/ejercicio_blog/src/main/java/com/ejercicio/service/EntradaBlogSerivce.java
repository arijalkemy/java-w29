package com.ejercicio.service;

import com.ejercicio.dto.BlogDto;
import com.ejercicio.exception.BlogNotCreatedException;
import com.ejercicio.model.EntradaBlog;
import com.ejercicio.repository.IEntradaBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<EntradaBlog> blog = entradaBlogRepository.findBlogById(id);
        ObjectMapper mapper = new ObjectMapper();
        mapper.convertValue()
        if(blog.isEmpty()){
            throw new
        }
        return blog.get();
    }
}
