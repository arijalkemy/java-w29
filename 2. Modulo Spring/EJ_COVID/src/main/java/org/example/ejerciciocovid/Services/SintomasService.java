package org.example.ejerciciocovid.Services;

import org.example.ejerciciocovid.Dtos.SintomasDto;

import java.util.List;

public interface SintomasService {

    List<SintomasDto> getAllSintomas();

    String findGravedadByName(String name);
}
