package com.example.covid.services;

import com.example.covid.dto.PersonaDeRiesgoDTO;

import java.util.List;

public interface IPersonaService {
    public List<PersonaDeRiesgoDTO> findRiskPerson();
}
