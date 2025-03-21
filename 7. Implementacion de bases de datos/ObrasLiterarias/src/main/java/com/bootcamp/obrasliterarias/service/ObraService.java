package com.bootcamp.obrasliterarias.service;

import com.bootcamp.obrasliterarias.dto.ObraDTO;
import com.bootcamp.obrasliterarias.repository.ObraRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObraService {
    private final ObraRepository obraRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public List<ObraDTO> buscarObrasPorAutor(String nombreAutor) {
        return obraRepository
                .findByAutor(nombreAutor)
                .stream()
                .map(o -> modelMapper.map(o, ObraDTO.class))
                .toList();
    }

    public Object buscarObrasPorTitulo(String titulo) {
        return obraRepository
                .findObraByTituloContaining(titulo)
                .stream()
                .map(o -> modelMapper.map(o, ObraDTO.class))
                .toList();
    }

    public List<ObraDTO> buscarTop5() {
        return obraRepository
                .findTop5()
                .stream()
                .map(o -> modelMapper.map(o, ObraDTO.class))
                .toList();
    }
}
