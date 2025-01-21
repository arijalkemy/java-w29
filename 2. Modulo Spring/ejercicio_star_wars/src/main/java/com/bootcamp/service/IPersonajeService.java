package com.bootcamp.service;

import com.bootcamp.dto.PersonajeDto;

import java.util.List;

public interface IPersonajeService {
    List<PersonajeDto> findByText(String text);
}
