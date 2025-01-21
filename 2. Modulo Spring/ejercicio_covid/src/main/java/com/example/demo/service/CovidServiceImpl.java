package com.example.demo.service;

import com.example.demo.dto.PersonasSintomasDto;
import com.example.demo.dto.SintomasDto;
import com.example.demo.model.Personas;
import com.example.demo.model.Sintomas;
import com.example.demo.repository.CovidRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CovidServiceImpl implements ICovidService {
    CovidRepositoryImpl repository ;

    public CovidServiceImpl(CovidRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public List<SintomasDto> serchSintomas() {
        List<Sintomas> listsintomas = repository.findSintomas();
        ObjectMapper mapper =new ObjectMapper();
        return listsintomas
                .stream()
                .map(s-> mapper.convertValue(s,SintomasDto.class))
                .toList();
    }

    @Override
    public SintomasDto serchByName(String n) {
        Sintomas sintoma = repository.findByName(n).orElse(null);
        ObjectMapper mapper =new ObjectMapper();
        return mapper.convertValue(sintoma,SintomasDto.class);
    }

    @Override
    public List<PersonasSintomasDto> serchPersonasRiesgo() {
        List<Personas> listPersonas = repository.findPersonasGrupoRiesgo();
        ObjectMapper mapper = new ObjectMapper();
        return listPersonas
                .stream()
                .map(p-> mapper.convertValue(p,PersonasSintomasDto.class))
                .toList();
    }
}
