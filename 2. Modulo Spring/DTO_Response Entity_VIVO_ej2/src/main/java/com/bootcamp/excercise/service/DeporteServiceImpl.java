package com.bootcamp.excercise.service;

import com.bootcamp.excercise.dto.CustumerDTO;
import com.bootcamp.excercise.entity.DeporteEntity;
import com.bootcamp.excercise.entity.PersonaEntity;
import com.bootcamp.excercise.repository.IDeporteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeporteServiceImpl implements IDeporteService {

    private final IDeporteRepository deporteRepository;

    public DeporteServiceImpl(IDeporteRepository deporteRepository) {
        this.deporteRepository = deporteRepository;
    }

    @Override
    public List<DeporteEntity> getAllSports() {
        return deporteRepository.findAllSports();
    }

    @Override
    public ResponseEntity<String> getSportLevelByName(String nombre) {
        DeporteEntity deporte = deporteRepository.findSportByName(nombre);
        if (deporte == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Deporte no encontrado");
        }
        return ResponseEntity.ok(deporte.getNivel());
    }

    public List<CustumerDTO> getAllSportsPersons() {
        List<CustumerDTO> deportistas = new ArrayList<>();
        List<PersonaEntity> personas = deporteRepository.findAllPersons();

        for (PersonaEntity persona : personas) {
            String deporte = "Fútbol";
            deportistas.add(new CustumerDTO(persona.getNombre(), persona.getApellido(), deporte));
        }
        return deportistas;
    }
}
