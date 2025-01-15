package com.ejercicio.service;

import com.ejercicio.dto.BlogDto;
import com.ejercicio.exception.BlogNotCreatedException;
import com.ejercicio.exception.ContentNotFoundException;
import com.ejercicio.model.EntradaBlog;
import com.ejercicio.repository.IEntradaBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaBlogSerivce implements IEntradaBlogService {

    @Autowired
    private IEntradaBlogRepository entradaBlogRepository;

    @Override
    public List<BlogDto> findAll() {
        ObjectMapper om = new ObjectMapper();
        return entradaBlogRepository
                .findAll()
                .stream()
                .map(b -> om.convertValue(b, BlogDto.class))
                .toList();
    }

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
        if(blog.isEmpty()){
            throw new ContentNotFoundException("El blog no fue encontrado");
        }
        return mapper.convertValue(blog.get(), BlogDto.class);
    }
}
