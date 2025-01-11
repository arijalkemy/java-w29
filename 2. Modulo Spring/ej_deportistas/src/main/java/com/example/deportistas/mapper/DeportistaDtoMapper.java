package com.example.deportistas.mapper;

import com.example.deportistas.dto.DeportistaDto;
import com.example.deportistas.model.Persona;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class DeportistaDtoMapper implements Function<Persona, DeportistaDto> {

    @Override
    public DeportistaDto apply(Persona p) {
        return new DeportistaDto(
                p.getNombre(),
                p.getApellido(),
                p.getDeporte().getNombre()
        );
    }
}
