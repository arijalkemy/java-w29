package com.meli.scaffolding.services;

import com.meli.scaffolding.dto.PersonaDto;
import com.meli.scaffolding.dto.SintomaDto;

import java.util.List;

public interface ICovidService {
    List<SintomaDto> sintomas();
    Integer nivelDeGravedad(String name);
    List<PersonaDto> getRiskPersons();
}
