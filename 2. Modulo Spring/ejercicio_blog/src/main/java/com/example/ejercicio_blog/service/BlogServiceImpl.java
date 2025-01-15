package com.example.ejercicio_blog.service;

import com.example.ejercicio_blog.dto.EntradaBlogDto;
import com.example.ejercicio_blog.entity.EntradaBlog;
import com.example.ejercicio_blog.exception.EntradaBlogAlreadyExistsException;
import com.example.ejercicio_blog.exception.EntradaBlogNotFoundException;
import com.example.ejercicio_blog.repository.IBlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BlogServiceImpl implements IBlogService {

    private final IBlogRepository blogRepository;

    @Override
    public EntradaBlogDto getBlogById(Integer id) {
        Optional<EntradaBlog> oEntrada = blogRepository.getBlogById(id);
        if(oEntrada.isEmpty()){
            throw new EntradaBlogNotFoundException("No se encontró la entrada con id: " + id);
        }
        return EntradaBlogDto.convertToDto(oEntrada.get());
    }

    @Override
    public List<EntradaBlogDto> getAll() {
        List<EntradaBlog> entradas = blogRepository.getAll();
        if(entradas.isEmpty()){
            throw new EntradaBlogNotFoundException("No se encontraron entradas en el blog.");
        }
        return entradas.stream().map(EntradaBlogDto::convertToDto).toList();
    }

    @Override
    public String createBlog(EntradaBlog entradaBlog) {
        Optional<EntradaBlog> oEntrada = blogRepository.getBlogById(entradaBlog.getId());
        if(oEntrada.isPresent()) {
            throw new EntradaBlogAlreadyExistsException("La entrada con id " + entradaBlog.getId() + " ya existe en el blog.");
        }
        Integer nuevoId = blogRepository.addEntrada(entradaBlog);
        return "Se creó la entrada de blog con id: " + nuevoId;
    }
}
