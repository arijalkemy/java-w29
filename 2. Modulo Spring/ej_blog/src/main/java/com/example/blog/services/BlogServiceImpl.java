package com.example.blog.services;

import com.example.blog.dto.EntradaBlogRequest;
import com.example.blog.entities.EntradaBlog;
import com.example.blog.exceptions.NotFoundException;
import com.example.blog.repositories.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {

    private Long maxId = 1L;

    private final BlogRepository repo;

    @Override
    public EntradaBlog save(EntradaBlogRequest entradaBlogRequest) {
        EntradaBlog nuevo = EntradaBlog.builder()
                .id(maxId++)
                .autor(entradaBlogRequest.autor())
                .titulo(entradaBlogRequest.titulo())
                .fechaPublicacion(LocalDate.now())
                .build();
        repo.save(nuevo);
        return nuevo;
    }

    @Override
    public EntradaBlog findById(Long id) {
        return repo.getById(id).orElseThrow(() -> new NotFoundException("Entrada blog no encontrada"));
    }

    @Override
    public List<EntradaBlog> findAll() {
        return repo.getAll();
    }
}
