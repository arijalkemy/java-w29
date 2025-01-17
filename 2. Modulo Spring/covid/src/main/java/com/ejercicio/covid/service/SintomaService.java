package com.ejercicio.covid.service;

import com.ejercicio.covid.model.Sintoma;
import com.ejercicio.covid.repository.SintomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SintomaService {

    private SintomaRepository sintomaRepository;

    @Autowired
    public SintomaService(SintomaRepository sintomaRepository) {
        this.sintomaRepository = sintomaRepository;
        Sintoma s1 = new Sintoma(1, "Fiebre", 5);
        Sintoma s2 = new Sintoma(2, "Migrana", 1);
        Sintoma s3 = new Sintoma(3, "Debilidad", 8);
        this.sintomaRepository.addSintoma(s1);
        this.sintomaRepository.addSintoma(s2);
        this.sintomaRepository.addSintoma(s3);
    }

    public List<Sintoma> getAllSintomas() {
        return this.sintomaRepository.findAll();
    }

    public Optional<Sintoma> getSintomaByName(String name) {
        return this.sintomaRepository.findByName(name);
    }
}
