package org.bootcamp.dtoyresponseentityp2.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.bootcamp.dtoyresponseentityp2.dto.DeportistaDTO;
import org.bootcamp.dtoyresponseentityp2.model.Persona;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final DeporteService deporteService;

    private final List<DeportistaDTO> deportistas = new ArrayList<>();

    private final List<Persona> personas = List.of(new Persona("Andres", "Largo", 27),
            new Persona("Sandra", "Perez", 26));

    @PostConstruct
    public void inicializarDeportistas(){
        Random random = new Random();
        personas.forEach(persona -> {
            deportistas.add(new DeportistaDTO(persona.getNombre(), persona.getApellido(),
                    deporteService.getDeportes().get(random.nextInt(deporteService.getDeportes().size())).getNombre()));
        });
    }

    public List<DeportistaDTO> getPersonasDeportistas(){
        return deportistas;
    }
}
