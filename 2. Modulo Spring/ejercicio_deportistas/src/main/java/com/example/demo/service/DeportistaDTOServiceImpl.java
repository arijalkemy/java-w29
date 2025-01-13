package com.example.demo.service;

import com.example.demo.DTO.DeportistaDTO;
import com.example.demo.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class DeportistaDTOServiceImpl implements DeportistaDTOService {

    private List<Persona> personaList =new ArrayList<>();
    @Override
    public List<DeportistaDTO> findAll() {
        return personaList.stream().map(persona -> new DeportistaDTO(persona)).collect(Collectors.toList());
    }

    @Override
    public void addPersona(Persona p) {
        personaList.add(p);
    }
}
