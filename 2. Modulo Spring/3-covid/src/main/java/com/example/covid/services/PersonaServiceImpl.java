package com.example.covid.services;

import com.example.covid.dto.PersonaDeRiesgoDTO;
import com.example.covid.repositories.IPersonaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaServiceImpl implements IPersonaService{
    IPersonaRepository iPersonaRepository;

    public PersonaServiceImpl(IPersonaRepository iPersonaRepository) {
        this.iPersonaRepository = iPersonaRepository;
    }

    @Override
    public List<PersonaDeRiesgoDTO> findRiskPerson() {
        ObjectMapper mapper = new ObjectMapper();
        return this.iPersonaRepository.findRiskPerson().stream()
                .map(p -> mapper.convertValue(p, PersonaDeRiesgoDTO.class))
                .toList();
    }
}
