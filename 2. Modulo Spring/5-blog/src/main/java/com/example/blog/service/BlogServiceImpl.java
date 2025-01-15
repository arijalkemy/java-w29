package com.example.blog.service;

import com.example.blog.dto.EntradaBlogDto;
import com.example.blog.entity.EntradaBlog;
import com.example.blog.exception.BlogAlreadyExistsException;
import com.example.blog.exception.BlogNotFoundException;
import com.example.blog.exception.EmptyBlogsException;
import com.example.blog.repository.IBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements IBlogService{

    private final IBlogRepository iBlogRepository;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public String crearEntradaBlog(EntradaBlogDto entradaBlogDto) {
        if(this.iBlogRepository.getById(entradaBlogDto.getId()) != null){
            throw new BlogAlreadyExistsException("Ya existe un blog. Id: " + entradaBlogDto.getId());
        }

        this.iBlogRepository.addEntradaBlog(mapper.convertValue(entradaBlogDto, EntradaBlog.class));
        return "Se ha creado correctamente. Id: " + entradaBlogDto.getId();
    }

    @Override
    public EntradaBlogDto getBlogById(Long id) {
        EntradaBlog entradaBlog = this.iBlogRepository.getById(id);
        if(entradaBlog == null){
            throw new BlogNotFoundException("No se encontró el blog");
        }
        return mapper.convertValue(entradaBlog, EntradaBlogDto.class);
    }

    @Override
    public List<EntradaBlogDto> getAll() {
        List<EntradaBlog> entradas = this.iBlogRepository.findAll();
        if(entradas.isEmpty()){
            throw new EmptyBlogsException("No hay blogs aún");
        }

        return entradas.stream().map(e -> mapper.convertValue(e, EntradaBlogDto.class)).toList();
    }

    // 1. crear forma que me gusta.
    /*@Override
    public String crearEntradaBlog(EntradaBlogDto entradaBlogDto) {
        EntradaBlog entradaBlog = mapper.convertValue(entradaBlogDto, EntradaBlog.class);
        entradaBlog.setId(this.iBlogRepository.nextId());
        this.iBlogRepository.addEntradaBlog(entradaBlog);
        return "Se ha creado correctamente. Id: " + entradaBlog.getId();
    }*/

}
