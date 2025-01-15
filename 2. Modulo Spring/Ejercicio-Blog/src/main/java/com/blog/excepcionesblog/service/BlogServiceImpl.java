package com.blog.excepcionesblog.service;

import com.blog.excepcionesblog.Entity.EntradaBlog;
import com.blog.excepcionesblog.dto.EntradaBlogDTO;
import com.blog.excepcionesblog.exception.AlreadyExistsException;
import com.blog.excepcionesblog.exception.NotFoundException;
import com.blog.excepcionesblog.repository.BlogRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements IBlogService{

    private final BlogRepositoryImpl blogRepository;

    @Override
    public String crearEntrada(EntradaBlogDTO entradaBlogDTO) {

        if (blogRepository.findById(entradaBlogDTO.getId()) != null) {
            throw new AlreadyExistsException("La entrada ya existe");
        }

        EntradaBlog entradaBlog = new EntradaBlog(
                entradaBlogDTO.getId(),
                entradaBlogDTO.getTitulo(),
                entradaBlogDTO.getAutor(),
                LocalDateTime.now()
        );

        blogRepository.save(entradaBlog);
        return "Entrada creada correctamente con ID: " + entradaBlog.getId();
    }

    @Override
    public EntradaBlogDTO obtenerEntradaPorId(Integer id) {

        EntradaBlog entradaBlog = blogRepository.findById(id);

        if (entradaBlog == null) {
            throw new NotFoundException("Entrada no encontrada");
        }

        return new EntradaBlogDTO(
                entradaBlog.getId(),
                entradaBlog.getTitulo(),
                entradaBlog.getAutor(),
                entradaBlog.getFechaPublicacion()
        );
    }

    @Override
    public Map<Integer, EntradaBlogDTO> obtenerTodasLasEntradas() {
        return blogRepository.findAll().values().stream()
                .map(entradaBlog -> new EntradaBlogDTO(
                        entradaBlog.getId(),
                        entradaBlog.getTitulo(),
                        entradaBlog.getAutor(),
                        entradaBlog.getFechaPublicacion()))
                .collect(Collectors.toMap(EntradaBlogDTO::getId, entradaBlogDTO -> entradaBlogDTO));
    }
}
