package com.bootcamp.youtuber.service;

import com.bootcamp.youtuber.dto.EntradaBlogDTO;
import com.bootcamp.youtuber.exception.AlreadyPostedException;
import com.bootcamp.youtuber.exception.BlogNotFoundException;
import com.bootcamp.youtuber.model.EntradaBlog;
import com.bootcamp.youtuber.repository.EntradaBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EntradaBlogService {

    private static final ObjectMapper objectMapper = new ObjectMapper();
    private final EntradaBlogRepository entradaBlogRepository;

    public Object addBlog(EntradaBlogDTO entradaBlogDTO) {

        checkIfAlreadyPosted(entradaBlogDTO.id());

        EntradaBlog entradaBlog = objectMapper.convertValue(entradaBlogDTO, EntradaBlog.class);

        entradaBlog.setFechaPublicacion(LocalDate.now());

        entradaBlogRepository.save(entradaBlog);

        return entradaBlog.getId();

    }

    private void checkIfAlreadyPosted(int id) {
        if (entradaBlogRepository.existsById(id)) {
            throw new AlreadyPostedException("La entrada con el id " + id + " ya existe.");
        }
    }

    public EntradaBlogDTO getById(int id) {
        checkIfAlreadyPosted(id);

        Optional<EntradaBlog> oEntradaBlog = entradaBlogRepository.findById(id);

        if (oEntradaBlog.isEmpty()) {
            throw new BlogNotFoundException("La entrada con el id " + id + "no existe");
        }

        EntradaBlog entradaBlog = oEntradaBlog.get();

        return toDTO(entradaBlog);

    }

    public List<EntradaBlogDTO> getAll() {
        return entradaBlogRepository
                .getAll()
                .stream()
                .map(this::toDTO)
                .toList();
    }

    private EntradaBlogDTO toDTO(EntradaBlog entradaBlog) {
        return new EntradaBlogDTO(
                entradaBlog.getId(),
                entradaBlog.getTitulo(),
                entradaBlog.getNombreAutor(),
                entradaBlog.getFechaPublicacion()
                );
    }

}
