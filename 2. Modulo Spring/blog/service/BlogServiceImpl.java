package com.example.blog.service;

import com.example.blog.dto.EntradaBlogDto;
import com.example.blog.entity.EntradaBlog;
import com.example.blog.exceptions.ConflictException;
import com.example.blog.exceptions.NotFoundException;
import com.example.blog.repository.BlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BlogServiceImpl implements IBlogService {
    private BlogRepository blogRepository;

    @Override
    public String crearEntradaBlog(EntradaBlogDto blog) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<EntradaBlog> blogEncontrado = blogRepository.getById(blog.getId());

        if (blogEncontrado.isPresent()) {
            throw new ConflictException("Entrada con id " + blog.getId() + " ya existe");
        }
        EntradaBlog blog1 = blogRepository.crearEntradaBlog(mapper.convertValue(blog, EntradaBlog.class));
        return "Blog con id " + blog1.getId() + " creado exitosamente";
    }

    @Override
    public EntradaBlogDto getEntradaBlog(Long id) {
        ObjectMapper mapper = new ObjectMapper();
        Optional<EntradaBlog> blogEncontrado = blogRepository.getById(id);

        if (blogEncontrado.isEmpty()) {
            throw new NotFoundException("Entrada con id " + id + " no encontrado");
        }

        return mapper.convertValue(blogEncontrado.get(), EntradaBlogDto.class);
    }

    @Override
    public List<EntradaBlogDto> getAllEntradasBlog() {
        ObjectMapper mapper = new ObjectMapper();
        List<EntradaBlogDto> blogs = blogRepository.getAll().stream().map(b -> mapper.convertValue(b, EntradaBlogDto.class)).toList();
        return blogs;
    }
}
