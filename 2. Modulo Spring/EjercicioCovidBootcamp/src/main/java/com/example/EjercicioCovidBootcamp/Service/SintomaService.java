package com.example.EjercicioCovidBootcamp.Service;

import com.example.EjercicioCovidBootcamp.DTO.SintomaPersonaDTO;
import com.example.EjercicioCovidBootcamp.Entity.Sintoma;
import com.example.EjercicioCovidBootcamp.Repository.ISintomaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class SintomaService implements ISintomaSerivce{

    ISintomaRepository sintomaRepository;
    public SintomaService(ISintomaRepository sintomaRepository) {
        this.sintomaRepository = sintomaRepository;
    }

    @Override
    public List<String> findSymptom() {
        List<Sintoma> listaSintomas = sintomaRepository.findSintomas();
        return listaSintomas.stream().map(Sintoma::toString).collect(Collectors.toList());
    }

    @Override
    public Sintoma findSymptomByName(String nombre) {
        List<Sintoma> listaSintomas = sintomaRepository.findSintomas();
        return listaSintomas.stream().filter(s -> s.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    @Override
    public SintomaPersonaDTO findRiskPerson(){
        
        return null;
    }
}
