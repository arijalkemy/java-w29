package com.example.deportistas.services;

import com.example.deportistas.dtos.DeportistaDto;
import com.example.deportistas.repositories.PersonasRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PersonasServiceImpl implements PersonasService {

    private final PersonasRepository personaRepository;


    @Override
    public List<DeportistaDto> getAllPersonas() {
        return personaRepository.getAll().stream().map(DeportistaDto::toDto).toList();
    }
}
