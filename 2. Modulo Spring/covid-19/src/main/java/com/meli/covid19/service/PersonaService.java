package com.meli.covid19.service;

import com.meli.covid19.dto.PersonaDTO;
import com.meli.covid19.model.PersonaModel;
import com.meli.covid19.model.SintomaModel;
import com.meli.covid19.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaService {

    private final PersonaRepository personaRepository;
    private final SintomaService sintomaService;

    @Autowired
    public PersonaService(PersonaRepository personaRepository, SintomaService sintomaService) {
        this.personaRepository = personaRepository;
        this.sintomaService = sintomaService;
    }

    public List<PersonaDTO> getRiskPersonas() {
        List<PersonaModel> personas;
        personas =  this.personaRepository.GetAllPersonas();

        List<PersonaDTO> personasDTO = new ArrayList<>();

        personas.stream().forEach(persona -> {
            List<SintomaModel> sintomas = new ArrayList<>();

            persona.sintomas.stream().forEach(sintoma -> {
                sintomas.add(sintomaService.getSintomaById(sintoma));
            });
            if(sintomas.size() > 0) {
                personasDTO.add(new PersonaDTO(persona.apellido, persona.edad, persona.nombre, sintomas));
            }
        });

        return personasDTO.stream().filter(personaDTO -> personaDTO.edad >= 60).collect(Collectors.toList());
    }
}
