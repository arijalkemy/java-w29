package com.bootcamp.covid.services;

import com.bootcamp.covid.dtos.SintomaDto;

import java.util.List;

public interface SintomasService {
    List<SintomaDto> getAllSintomas();

    String findGravedadByName(String name);
}
