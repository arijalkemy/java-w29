package org.example.ejerciciocovid.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ejerciciocovid.Dtos.SintomasDto;
import org.example.ejerciciocovid.Entities.Sintoma;
import org.example.ejerciciocovid.Repositories.PersonaRepositoryImpl;
import org.example.ejerciciocovid.Repositories.SintomasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SintomasServiceImpl implements SintomasService {

    private final SintomasRepository repository;

    public SintomasServiceImpl(SintomasRepository repository)
    {
        this.repository = repository;
    }

    @Override
    public List<SintomasDto> getAllSintomas() {
        ObjectMapper mapper = new ObjectMapper();
        List<Sintoma> sintomas = repository.getAll();
        return sintomas.stream().map(s -> mapper.convertValue(s, SintomasDto.class))
                .toList();
    }

    @Override
    public String findGravedadByName(String name) {
        Sintoma sintoma = repository
                .getByName(name)
                .orElseThrow(() -> new NoSuchElementException("No se encontró el síntoma " + name));

        return sintoma.getNivelGravedad().getString();
    }
}
