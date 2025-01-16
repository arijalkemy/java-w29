package com.meli.scaffolding.services;

import com.meli.scaffolding.dto.PersonaDto;
import com.meli.scaffolding.dto.SintomaDto;
import com.meli.scaffolding.entities.Sintoma;
import com.meli.scaffolding.repository.ICovidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CovidServiceImpl implements ICovidService{

    private final ICovidRepository repositoryCovid;

    @Override
    public List<SintomaDto> sintomas() {
        List<Sintoma> sintomas = repositoryCovid.getSintomas();
        List<SintomaDto> sintomaDtos = new ArrayList<>();
        for (Sintoma s : sintomas){
            SintomaDto sintomaDto = new SintomaDto();
            sintomaDto.setNombre(s.getNombre());
            sintomaDto.setNivel_de_gravedad(s.getNivel_de_gravedad());
            sintomaDtos.add(sintomaDto);
        }
        return sintomaDtos;
    }

    @Override
    public Integer nivelDeGravedad(String name) {
        Optional<Sintoma> s = repositoryCovid.getByName(name);
        if(s.isEmpty()){
            throw new IllegalArgumentException("No existe sintoma con ese nombre");
        }
        return repositoryCovid.nivelDeGravedad(name);
    }

    public List<PersonaDto> getRiskPersons() {
        return repositoryCovid.getPersonas().stream()
                .filter(persona -> persona.getEdad() > 60)
                .map(persona -> {
                    List<SintomaDto> sintomaDtos = persona.getSintomas().stream()
                            .map(sintoma -> new SintomaDto(sintoma.getNombre(), sintoma.getNivel_de_gravedad()))
                            .collect(Collectors.toList());

                    return new PersonaDto(persona.getNombre(), persona.getApellido(), persona.getEdad(), sintomaDtos);
                })
                .collect(Collectors.toList());
    }
}
