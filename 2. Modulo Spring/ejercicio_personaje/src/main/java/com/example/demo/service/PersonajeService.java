package com.example.demo.service;

import com.example.demo.dto.PersonajeDTO;
import com.example.demo.model.Personaje;

import java.util.List;

public interface PersonajeService {
    List<PersonajeDTO> findByNombre (String n);
}
