package com.example.deportistas.services;

import com.example.deportistas.dtos.DeportistaDto;
import com.example.deportistas.repositories.PersonasRepository;
import com.example.deportistas.utils.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonasServiceImpl implements PersonasService {

    private final PersonasRepository personaRepository;


    @Override
    public List<DeportistaDto> findAllPersonas() {
        return personaRepository.findAll().stream()
                .map(Mapper::toDto)
                .toList();
    }
}
