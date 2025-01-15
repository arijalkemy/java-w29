package com.example.ejercicio_blog.services;

import com.example.ejercicio_blog.dto.EntradaBlogDto;
import com.example.ejercicio_blog.dto.response.EntradaSuccessDto;
import com.example.ejercicio_blog.entity.EntradaBlog;
import com.example.ejercicio_blog.exceptions.ExistentEntryException;
import com.example.ejercicio_blog.exceptions.NotFoundEntryException;
import com.example.ejercicio_blog.repository.EntradaRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EntradaServiceImpl implements IEntradaService{

    private EntradaRepositoryImpl entradaRepository;


    @Override
    public List<EntradaBlogDto> listAll() {
        return entradaRepository.getAll().stream()
                .map(entrada -> EntradaBlogDto.builder().id(entrada.getId()).titulo(entrada.getTitulo()).nombreAutor(entrada.getNombreAutor()).fechaPublicacion(entrada.getFechaPublicacion()).build())
                .collect(Collectors.toList());
    }

    @Override
    public EntradaSuccessDto add(EntradaBlogDto entrada) {
        EntradaBlog entradaBlog = EntradaBlog.builder()
                .id(entrada.getId())
                .titulo(entrada.getTitulo())
                .nombreAutor(entrada.getNombreAutor())
                .fechaPublicacion(entrada.getFechaPublicacion())
                .build();

        if (entradaRepository.findById(entrada.getId()).isPresent()) {
            throw new ExistentEntryException("Entrada con id " + entrada.getId() + " ya existe");
        }

        if (!entradaRepository.add(entradaBlog)) {
            throw new RuntimeException("Error al añadir la entrada");
        }
        return EntradaSuccessDto.builder().id(entradaBlog.getId()).build();
    }

    @Override
    public EntradaBlogDto findById(Integer id) {
        Optional<EntradaBlog> entrada = entradaRepository.findById(id);

        if (entrada.isEmpty()) {
            throw new NotFoundEntryException("Entrada con id " + id + " no encontrada");
        }

        return EntradaBlogDto.builder().id(entrada.get().getId()).titulo(entrada.get().getTitulo()).nombreAutor(entrada.get().getNombreAutor()).fechaPublicacion(entrada.get().getFechaPublicacion()).build();
    }
}
