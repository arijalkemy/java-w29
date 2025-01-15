package com.example.demo.service;

import com.example.demo.dto.PersonajeDTO;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDTO> obtenerPersonajes(String valor);
}
