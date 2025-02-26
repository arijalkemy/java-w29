package com.sport.deportistas.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sport.deportistas.dto.DeporteDTO;
import com.sport.deportistas.dto.DeportistaDTO;
import com.sport.deportistas.dto.PersonaDTO;
import com.sport.deportistas.entity.Deporte;
import com.sport.deportistas.entity.Persona;
import com.sport.deportistas.repository.DeportistasRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DeportistasServiceImpl implements IDeportistasService{

    private final DeportistasRepositoryImpl deportistasRepository;
    private Map<String, DeportistaDTO> sportPersons = new HashMap<>();

    public DeportistasServiceImpl(DeportistasRepositoryImpl deportistasRepository) {
        this.deportistasRepository = deportistasRepository;
    }

    @Override
    public List<DeporteDTO> findSports() {
        List<Deporte> deportes = deportistasRepository.searchDeportes();
        List<DeporteDTO> deporteDTOS = deportes.stream()
                .map(deporte -> new DeporteDTO(deporte.getNombre(), deporte.getNivel()))
                .collect(Collectors.toList());

        return deporteDTOS;
    }

    @Override
    public DeporteDTO findSportsByName(String name) {
        ObjectMapper mp = new ObjectMapper();
        Deporte deporte = deportistasRepository.searchDeporteByName(name);
        return mp.convertValue(deporte, DeporteDTO.class);
    }

    @Override
    public List<DeportistaDTO> findSportsPersons() {
        List<DeportistaDTO> deportistaDTOList = new ArrayList<>();

        List<Persona> personas = deportistasRepository.searchPersonas();
        List<Deporte> deportes = deportistasRepository.searchDeportes();

        for (int i = 0; i < personas.size(); i++) {
            DeportistaDTO deportistaDTO = new DeportistaDTO();
            Persona persona = personas.get(i);

            deportistaDTO.setNombre(persona.getNombre());
            deportistaDTO.setApellido(persona.getApellido());

            if (i < deportes.size()) {
                Deporte deporte = deportes.get(i);
                deportistaDTO.setDeporte(deporte.getNombre());
            } else {
                deportistaDTO.setDeporte("No asignado");
            }

            deportistaDTOList.add(deportistaDTO);

            sportPersons.put(persona.getNombre(), deportistaDTO);
        }

        return deportistaDTOList;
    }


}
