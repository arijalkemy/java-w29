package com.thiagoschreck.local.detectando_deportistas.service;

import com.thiagoschreck.local.detectando_deportistas.dto.DeporteDTO;
import com.thiagoschreck.local.detectando_deportistas.dto.PersonaDTO;
import com.thiagoschreck.local.detectando_deportistas.model.Deporte;
import com.thiagoschreck.local.detectando_deportistas.model.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsService {

    private final List<Deporte> deportes;
    private final List<Persona> personas;

    public SportsService() {
        Deporte deporte1 = new Deporte("Futbol", 1);
        Deporte deporte2 = new Deporte("Futbol", 2);
        Deporte deporte3 = new Deporte("Basketball", 1);
        Deporte deporte4 = new Deporte("Basketball", 2);

        Persona persona1 = new Persona("Johnny", "Test", 20, deporte1);
        Persona persona2 = new Persona("Johnny", "Test", 20, deporte3);
        Persona persona3 = new Persona("Lorena", "Ipsum", 19, deporte2);
        Persona persona4 = new Persona("Lorena", "Ipsum", 19, deporte4);

        deportes = List.of(deporte1, deporte2, deporte3, deporte4);
        personas = List.of(persona1, persona2, persona3, persona4);
    }

    public List<DeporteDTO> getAllSports() {
        return deportes.stream().map(this::mapToDTO).toList();
    }

    public List<DeporteDTO> getSportByName(String name) {
        return deportes.stream()
                .filter(deporte -> deporte.nombre().equalsIgnoreCase(name))
                .map(this::mapToDTO)
                .toList();
    }

    public List<PersonaDTO> getAllSportsPersons() {
        return personas.stream()
                .map(this::mapToDTO)
                .toList();
    }

    private PersonaDTO mapToDTO(Persona persona) {
        return new PersonaDTO(persona.nombre(), persona.apellido(), persona.deporte().nombre());
    }

    private DeporteDTO mapToDTO(Deporte deporte) {
        return new DeporteDTO(deporte.nombre(), deporte.nivel());
    }
}
