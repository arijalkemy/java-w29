package com.example.demo.service;

import com.example.demo.dto.PersonasSintomasDto;
import com.example.demo.dto.SintomasDto;

import java.util.List;

public interface ICovidService {
    List<SintomasDto> serchSintomas();

    SintomasDto serchByName(String n);

    List<PersonasSintomasDto> serchPersonasRiesgo();

}
