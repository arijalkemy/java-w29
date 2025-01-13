package com.example.demo.service;

import com.example.demo.DTO.DeportistaDTO;
import com.example.demo.model.Persona;

import java.util.List;

public interface DeportistaDTOService {

    public List<DeportistaDTO> findAll();

    public void addPersona(Persona p);
}
