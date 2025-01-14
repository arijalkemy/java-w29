package org.example.dto_responseentity_2_vivo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DeportistaService {

    private final List<Deporte> deportes = new ArrayList<>();
    private final List<Persona> personas = new ArrayList<>();
    private final List<DeportistaDeporteDTO> deportistas = new ArrayList<>();

    public DeportistaService() {
        // Datos hardcodeados
        deportes.add(new Deporte("Fútbol", NivelDeporte.MEDIO));
        deportes.add(new Deporte("Natación", NivelDeporte.ALTO));

        personas.add(new Persona("Juan", "Pérez", 25));
        personas.add(new Persona("Ana", "Martínez", 30));

        // Creación de deportistas DTO relacionando personas con deportes
        deportistas.add(new DeportistaDeporteDTO(personas.get(0).getNombre(), personas.get(0).getApellido(), deportes.get(0).getNombre()));
        deportistas.add(new DeportistaDeporteDTO(personas.get(1).getNombre(), personas.get(1).getApellido(), deportes.get(1).getNombre()));
    }

    public List<Deporte> findAllSports() {
        return deportes;
    }

    public Optional<NivelDeporte> findSportByName(String nombreDeporte) {
        return deportes.stream()
                .filter(deporte -> deporte.getNombre().equalsIgnoreCase(nombreDeporte))
                .map(Deporte::getNivel)
                .findFirst();
    }

    public List<DeportistaDeporteDTO> findSportsPersons() {
        return deportistas;
    }
}